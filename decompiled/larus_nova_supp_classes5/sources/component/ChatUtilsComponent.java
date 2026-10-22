package component;

import ce8.c;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.layout.holder.helper.o;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.holder.helper.x2;
import com.larus.bmhome.utils.x3;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import va8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bH\u0016¨\u0006\u0019"}, d2 = {"Lcomponent/ChatUtilsComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/ability/IChatUtilsAbility;", "<init>", "()V", "isContinuousTalk", "", "getUserBreakMsgId", "", "cvsId", "setUserBreakMsgId", "", "msgId", "isShowUserBreakMob", "showUserBreakMsgId", "updateLastShowUserBreakMsgId", "obtainLongClickListenerHelper", "Landroid/view/View$OnLongClickListener;", "data", "Lcom/larus/im/bean/message/Message;", "component", "Lcom/larus/ui/arch/component/external/api/receiver/AttachReceiver;", "obtainLongClickListenerHelperWithSimpleCreator", "markForceUpdateForMarkdown", "forceRefreshKey", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatUtilsComponent extends ComponentFeature implements y {
    public final boolean p8() {
        return c.a();
    }

    public ChatUtilsComponent() {
    }

    public final boolean Du(String r2) {
        String r0 = x3.a;
        if (o0.d(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2, x3.a) == false) goto L7;
        return true;
    }

    public final void L00(String r2) {
        String r0 = x3.a;
        x3.a = r2;
    }

    public final String e7(String r3) {
        String r0 = x3.a;
        if (r3 != null) goto L6;
        return "";
    L6:
        return ((Keva) x3.b.getValue()).getString(r3, "");
    }

    public final void pf(String r2) {
        Intrinsics.checkNotNullParameter(r2, "forceRefreshKey");
        com.larus.bmhome.chat.markdown.imagegroup.c.b(r2);
    }

    public final w0 bn(Message r3, ComponentFeature r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "component");
        int r0 = o.m;
        return new w0(o.a.a(r3, r4, null, 28));
    }

    public final void m4(String r2, String r3) {
        String r0 = x3.a;
        if (r2 == null) goto L9;
        if (r3 == null) goto L10;
        ((Keva) x3.b.getValue()).storeString(r2, r3);
        return;
    L10:
        return;
    }

    public final w0 rn(Message r3, AttachReceiver r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "component");
        int r0 = o.m;
        return new w0(o.a.a(r3, r4, new x2(), 24));
    }
}
