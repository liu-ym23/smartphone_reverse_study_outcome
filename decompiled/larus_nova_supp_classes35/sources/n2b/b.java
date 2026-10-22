package n2b;

import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.MessageListDataFeature;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements b3b.b {
    public final IMessageListViewModel a;
    public final InterfaceC0262b b;

    public static final class a {
    }

    /* JADX INFO: renamed from: n2b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0262b {
        void a();

        void b();

        List<y6b.c<?>> c();
    }

    static {
    }

    @Override // b3b.c
    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        IMessageListViewModel r0 = this.a;
        if (r0 == null) goto L6;
        r0.readAudioMsg(r2);
        return;
    }

    @Override // b3b.b
    public final List<String> y0(int r9) {
        List<y6b.c<?>> r0 = this.b.c();
        ArrayList r1 = new ArrayList();
        if (CollectionUtils.isNotEmpty(r0) == false) goto L19;
        int r2 = r0.size();
    L5:
        r9 = r9 + 1;
        if (r9 >= r2) goto L19;
        y6b.c r3 = (y6b.c) CollectionsKt.getOrNull(r0, r9);
        if (r3 == null) goto L5;
        if ((r3.o instanceof AudioContentVO) == false) goto L5;
        if (r3.i == true) goto L5;
        String r4 = r3.d;
        int r5 = r3.X;
        Log.i("AudioMessageCallback", "onGetAudioMessageCids cid:" + r4 + ",readState:" + r5 + ",msgId:" + r3.c + ",index:" + r9);
        if (r5 >= 2) goto L5;
        r1.add(r4);
    L19:
        return r1;
    }

    public b(IMessageListViewModel r2, MessageListDataFeature.d r3) {
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
    }

    @Override // b3b.b
    public final void z0(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "audioKey");
        Intrinsics.checkNotNullParameter(r10, "messageId");
        IMessageListViewModel r0 = this.a;
        if (r0 == null) goto L11;
        MutableLiveData<Chat> r1 = r0.getCurrentChat();
        if (r1 == null) goto L12;
        Chat r2 = (Chat) r1.getValue();
        if (r2 == null) goto L13;
        IMessageListViewModel r3 = this.a;
        this.b.b();
        this.b.a();
        IMessageListViewModel.prepareAudioData$default(r3, r10, null, null, null, 8, null);
        Log.i("AudioMessageCallback", "prepareAudioData-manual:" + r9 + '/' + r10 + '/' + r2.isSecret());
        return;
    L13:
        return;
    L12:
        return;
    }
}
