package u4b;

import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetDecryptedContentRequest;
import com.bytedance.lark.pb.im.v1.GetDecryptedContentResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final LruCache<String, Content> a;
    public final ReentrantReadWriteLock b;

    /* JADX INFO: renamed from: u4b.a$a, reason: collision with other inner class name */
    public static final class C0306a {
    }

    public static final class b {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public static final class c<T> implements SdkSender.IParser {
        public final /* synthetic */ List<Message> a;
        public final /* synthetic */ HashMap<String, Message> b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends Message> r1, HashMap<String, Message> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object parse(byte[] r8) {
            GetDecryptedContentResponse r9 = (GetDecryptedContentResponse) GetDecryptedContentResponse.ADAPTER.decode(r8);
            Log.d("SecretContentResolver", "get decrypted message content size: " + r9.contents.size() + ", request size: " + this.a.size() + ' ');
            Entity r0 = r9.entity;
            HashMap r1 = new HashMap();
            HashMap<String, Message> r2 = this.b;
            Iterator r10 = r9.contents.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L10;
            Map.Entry r3 = (Map.Entry) r10.next();
            String r4 = (String) r3.getKey();
            com.bytedance.lark.pb.basic.v1.Content r5 = (com.bytedance.lark.pb.basic.v1.Content) r3.getValue();
            Message r6 = r2.get(r4);
            if (r6 == null) goto L4;
            Content r7 = ModelParserMessage.e(r0, r6, r5, null);
            if (r7 == null) goto L4;
            r1.put(r4, r7);
            goto L4
        L10:
            return r1;
        }
    }

    static {
    }

    public a() {
        this.a = new LruCache(20);
        this.b = new ReentrantReadWriteLock();
    }

    public static Map a(List r5) {
        GetDecryptedContentRequest.Builder r0 = new GetDecryptedContentRequest.Builder();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r2 = r5.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((Message) r2.next()).getCryptoToken());
        goto L4
    L6:
        GetDecryptedContentRequest.Builder r3 = r0.decrypted_tokens(r1);
        HashMap r4 = new HashMap();
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Message r7 = (Message) r6.next();
        r4.put(r7.getId(), r7);
        goto L8
    L10:
        SdkSender.d r8 = SdkSender.syncSendMayError(Command.GET_DECRYPTED_CONTENT, r3, new c(r5, r4));
        if (r8.b == null) goto L14;
        Log.e("SecretContentResolver", "get decrypted message content failed: " + r8.b.getDisplayMsg());
        return null;
    L14:
        return (Map) r8.a;
    }

    public final Content b(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        if (r7.isSecretEncrypted() == false) goto L35;
        Log.i(TitlebarViewModel.LOG_TAG, "getMessageContent encrypted id: " + r7.getId());
        Intrinsics.checkNotNullParameter(r7, "message");
        ArrayList r0 = new ArrayList();
        r0.add(r7);
        Intrinsics.checkNotNullParameter(r0, "messages");
        this.b.writeLock().lock();     // Catch: Throwable -> L32
        ConcurrentHashMap r1 = new ConcurrentHashMap();     // Catch: Throwable -> L32
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L32
    L7:
        if (r2.hasNext() == false) goto L9;
        Message r3 = (Message) r2.next();     // Catch: Throwable -> L32
        r1.put(r3.getId(), r3);     // Catch: Throwable -> L32
        goto L7
    L9:
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L32
        ConcurrentHashMap r5 = new ConcurrentHashMap();     // Catch: Throwable -> L32
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Throwable -> L32
        Iterator r8 = r0.iterator();     // Catch: Throwable -> L32
    L11:
        if (r8.hasNext() == false) goto L13;
        r6.add(((Message) r8.next()).getId());     // Catch: Throwable -> L32
        goto L11
    L13:
        Iterator r9 = r6.iterator();     // Catch: Throwable -> L32
    L15:
        if (r9.hasNext() == false) goto L23;
        String r10 = (String) r9.next();     // Catch: Throwable -> L32
        Content r11 = this.a.get(r10);     // Catch: Throwable -> L32
        if (r11 == null) goto L18;
        r5.put(r10, r11);     // Catch: Throwable -> L32
        goto L15
    L18:
        Message r12 = (Message) r1.get(r10);     // Catch: Throwable -> L32
        if (r12 == null) goto L15;
        r4.add(r12);     // Catch: Throwable -> L32
        goto L15
    L23:
        if (CollectionUtils.isEmpty(r4) == true) goto L31;
        Map r13 = a(r4);     // Catch: Throwable -> L32
        if (r13 == null) goto L31;
        r5.putAll(r13);     // Catch: Throwable -> L32
        Iterator r14 = r13.entrySet().iterator();     // Catch: Throwable -> L32
    L27:
        if (r14.hasNext() == false) goto L31;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L32
        this.a.put((String) r15.getKey(), (Content) r15.getValue());     // Catch: Throwable -> L32
    L31:
        this.b.writeLock().unlock();
        return (Content) r5.get(r7.getId());
    L32:
        th = move-exception;
        this.b.writeLock().unlock();
        throw th;
    L35:
        Log.i(TitlebarViewModel.LOG_TAG, "getMessageContent normal id: " + r7.getId());
        return r7.getContent();
    }
}
