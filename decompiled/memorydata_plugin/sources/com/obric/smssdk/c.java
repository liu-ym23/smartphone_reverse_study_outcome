package com.obric.smssdk;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.obric.a.a.f;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/smssdk/SmsMmsObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "context", "Landroid/content/Context;", "(Landroid/os/Handler;Landroid/content/Context;)V", "delayMillis", "", "getHandler", "()Landroid/os/Handler;", "pendingDeleteMmsIds", "", "", "pendingDeleteSmsIds", "pendingIndexMmsIds", "pendingIndexSmsIds", "pendingUpdateMmsIds", "pendingUpdateSmsIds", "updateDeleteRunnable", "Ljava/lang/Runnable;", "updateIndexRunnable", "onChange", "", "selfChange", "", "notifyWithActionUri", "Landroid/net/Uri;", "printMessageEntity", "messageList", "", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "Companion", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class c extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f14981b;
    private final Context c;
    private final Set<String> d;
    private final Set<String> e;
    private final Set<String> f;
    private final Set<String> g;
    private final Set<String> h;
    private final Set<String> i;
    private final long j;
    private final Runnable k;
    private final Runnable l;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/smssdk/SmsMmsObserver$Companion;", "", "()V", "DELETE_ACTION", "", "INSERT_ACTION", "TAG", "UPDATE_ACTION", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14980a = new a(null);
    }

    public c(Handler r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r3);
        this.f14981b = r3;
        this.c = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.d = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.e = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.f = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.g = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.h = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.i = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.j = 1000;
        this.k = new $$Lambda$c$YMYOdVAYnxeli1FQRss31rvT8bE(this);
        this.l = new $$Lambda$c$VzbqcbWIX8N7tk1ouljHQaFnCs(this);
    }

    private static final void a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (((!((Collection) ZeusTransformUtils.preCheckCast(r5.d, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) | (!((Collection) ZeusTransformUtils.preCheckCast(r5.f, Collection.class, "com.obric.memorydata.plugin")).isEmpty())) == false) goto L8;
        List<String> r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.union((Iterable) ZeusTransformUtils.preCheckCast(r5.d, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.f, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        r5.d.clear();
        r5.f.clear();
        List<MessageEntity> r1 = com.obric.smssdk.utils.a.f14982a.a(r0, "sms", r5.c);
        r5.a(r1);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        com.obric.a.a.b.f5863a.a(r1);
    L8:
        if (((!((Collection) ZeusTransformUtils.preCheckCast(r5.g, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) | (!((Collection) ZeusTransformUtils.preCheckCast(r5.i, Collection.class, "com.obric.memorydata.plugin")).isEmpty())) == false) goto L13;
        List<String> r2 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.union((Iterable) ZeusTransformUtils.preCheckCast(r5.g, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.i, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        r5.g.clear();
        r5.i.clear();
        List<MessageEntity> r3 = com.obric.smssdk.utils.a.f14982a.a(r2, "mms", r5.c);
        r5.a(r3);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        com.obric.a.a.b.f5863a.a(r3);
        return;
    L14:
        return;
    }

    private final void a(List<MessageEntity> r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        MessageEntity r6 = (MessageEntity) ZeusTransformUtils.preCheckCast(r4.next(), MessageEntity.class, "com.obric.memorydata.plugin");
        f.f5867a.a("SmsMmsObserver", "printMessageEntity, msg_id = " + r6.getId() + ", status = " + r6.getMessageStatusType());
        goto L4
    }

    private static final void b(c r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10.e, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r10.e, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r6.add("sms_" + ((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")));
        goto L6
    L8:
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        f.f5867a.a("SmsMmsObserver", "updateDeleteRunnable: " + r2);
        r10.e.clear();
        com.obric.a.a.b.f5863a.a(r2, 101);
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10.h, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r10.h, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        r5.add("mms_" + ((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")));
        goto L13
    L15:
        List<String> r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        f.f5867a.a("SmsMmsObserver", "updateDeleteRunnable: " + r7);
        r10.h.clear();
        com.obric.a.a.b.f5863a.a(r7, 101);
        return;
    }

    /* JADX INFO: renamed from: lambda$-VzbqcbWIX8N7tk1ouljHQaFnCs, reason: not valid java name */
    public static /* synthetic */ void m1399lambda$VzbqcbWIX8N7tk1ouljHQaFnCs(c r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$YMYOdVAYnxeli1FQRss31rvT8bE(c r0) {
        a(r0);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r9, Uri r10) {
        f.f5867a.a("SmsMmsObserver", "Observer changed!!!, uri = " + r10);
        String r11 = null;
        if (r10 == null) goto L5;
        String r0 = r10.getQueryParameter("type");
    L6:
        if (r10 == null) goto L8;
        String r1 = r10.getQueryParameter("action");
    L9:
        if (r10 == null) goto L11;
        r11 = r10.getQueryParameter("rowIds");
    L11:
        if (r0 == null) goto L95;
        if (r1 == null) goto L112;
        if (r11 == null) goto L113;
        List r12 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null);
        int r13 = r1.hashCode();
        if (r13 == (-1335458389)) goto L63;
        if (r13 == (-1183792455)) goto L42;
        if (r13 == (-838846263)) goto L23;
        return;
    L23:
        if (r1.equals(BuildConfig.CHANNEL) == true) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(r0, "sms") == false) goto L34;
        Set<String> r14 = this.f;
        monitor-enter(r14);
        this.f.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
    L56:
        monitor-exit(r14);
        this.f14981b.removeCallbacks(this.k);
        Handler r15 = this.f14981b;
        Runnable r16 = this.k;
    L58:
        r15.postDelayed(r16, this.j);
        return;
    L31:
        th = move-exception;
        throw th;
    L34:
        r14 = this.i;
        monitor-enter(r14);
        this.i.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L42:
        if (r1.equals("insert") == true) goto L45;
        return;
    L45:
        if (Intrinsics.areEqual(r0, "sms") == false) goto L53;
        r14 = this.d;
        monitor-enter(r14);
        this.d.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    L53:
        r14 = this.g;
        monitor-enter(r14);
        this.g.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L63:
        if (r1.equals("delete") == true) goto L66;
        return;
    L66:
        if (Intrinsics.areEqual(r0, "sms") == false) goto L80;
        Set<String> r17 = this.e;
        monitor-enter(r17);
        this.e.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
        Set r18 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L72;
        this.f.removeAll((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
    L72:
        Set r19 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.d, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L75;
        this.d.removeAll((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
        this.e.removeAll((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
    L75:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L77
    L89:
        monitor-exit(r17);
        this.f14981b.removeCallbacks(this.l);
        r15 = this.f14981b;
        r16 = this.l;
    L77:
        th = move-exception;
        throw th;
    L80:
        r17 = this.h;
        monitor-enter(r17);
        this.h.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92
        Set r21 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(this.h, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L85;
        this.i.removeAll((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92
    L85:
        Set r22 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(this.h, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L88;
        this.h.removeAll((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92
        this.g.removeAll((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92
    L88:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        throw th;
    L113:
        return;
    L112:
        return;
    L95:
        return;
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = null;
        goto L6
    }
}
