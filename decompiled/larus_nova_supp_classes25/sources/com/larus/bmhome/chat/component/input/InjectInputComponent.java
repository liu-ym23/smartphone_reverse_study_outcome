package com.larus.bmhome.chat.component.input;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.larus.bmhome.chat.ab.InputMultilineScene;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001-B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0012\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0016\u0010&\u001a\u00020\u001c2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070(H\u0016J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001fH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/component/input/InjectInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/injectinput/IInjectInputAbility;", "<init>", "()V", "inputMultilineSceneKey", "", "getInputMultilineSceneKey", "()Ljava/lang/String;", "injectInputCallback", "Lcom/larus/bmhome/injectinput/IInjectInputCallback;", "getInjectInputCallback", "()Lcom/larus/bmhome/injectinput/IInjectInputCallback;", "setInjectInputCallback", "(Lcom/larus/bmhome/injectinput/IInjectInputCallback;)V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "onResume", "setCallback", "callback", "onAttachmentDeleted", "uri", "Landroid/net/Uri;", "onCameraCaptureSuccess", "uriList", "", "onShowInputView", "inputView", "addedItemUri", "onHideInputView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class InjectInputComponent extends BaseContentWidget implements op8.e {
    public static final /* synthetic */ int q = 0;
    public final String m;
    public op8.f n;
    public final Lazy o;
    public final Lazy p;

    public static final class a {
    }

    static {
    }

    public void o8() {
    }

    public void stopInput() {
    }

    public final ICoreInputAbility Y2() {
        return (ICoreInputAbility) this.o.getValue();
    }

    public final z8 h3() {
        return (z8) this.p.getValue();
    }

    public void onResume() {
        FLogger.a.i("InjectInputComponent", "[onResume]");
        ICoreInputAbility r0 = Y2();
        if (r0 == null) goto L5;
        r0.Rk();
    L5:
        ICoreInputAbility r1 = Y2();
        if (r1 == null) goto L9;
        r1.tr(new o(this));
        return;
    }

    public final void y2() {
        FLogger.a.i("InjectInputComponent", "[onAttach]");
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, op8.e.class);
    }

    public InjectInputComponent() {
        this.m = InputMultilineScene.ALBUM_QUICK_INPUT.getSceneKey();
        this.o = LazyKt.lazy(new p(this));
        this.p = LazyKt.lazy(new q(this));
    }

    public String m3() {
        return this.m;
    }

    public final void A3(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "uriList");
        op8.f r0 = this.n;
        if (r0 == null) goto L6;
        r0.A3(r2);
        return;
    }

    public void M2(op8.i.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inputType");
    }

    public void Tv(op8.f r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        FLogger.a.i("InjectInputComponent", "[setCallback] callback:" + r5);
        this.n = r5;
        if (r5 == null) goto L16;
        Map r6 = r5.getEventInfo();
        if (r6 == null) goto L17;
        z8 r0 = h3();
        if (r0 == null) goto L18;
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = (String) r6.get("camera_mob_key_chat_key");
        if (r2 == null) goto L11;
        String r3 = r1.put("take_over_chat_key", r2);
    L11:
        String r7 = (String) r6.get("camera_mob_key_current_page");
        if (r7 == null) goto L14;
        r1.put("take_over_current_page", r7);
    L14:
        r0.g9(r1);
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void f4(View r2) {
        Intrinsics.checkNotNullParameter(r2, "inputView");
        op8.f r0 = this.n;
        if (r0 == null) goto L6;
        r0.f4(r2);
        return;
    }

    public final void h0(Uri r2) {
        op8.f r0 = this.n;
        if (r0 == null) goto L6;
        r0.h0(r2);
        return;
    }

    public void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("InjectInputComponent", "[onViewCreated]");
        ICoreInputAbility r4 = Y2();
        if (r4 == null) goto L5;
        r4.Q8(m3());
    L5:
        z8 r5 = h3();
        if (r5 == null) goto L8;
        r5.R8();
    L8:
        z8 r6 = h3();
        if (r6 == null) goto L11;
        r6.w8();
    L11:
        z8 r7 = h3();
        if (r7 == null) goto L14;
        r7.w9(false);
    L14:
        z8 r8 = h3();
        if (r8 == null) goto L17;
        r8.s9();
    L17:
        z8 r9 = h3();
        if (r9 == null) goto L21;
        r9.r8(false, null);
        return;
    }

    public final void M7(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "inputView");
        Intrinsics.checkNotNullParameter(r3, "addedItemUri");
        op8.f r0 = this.n;
        if (r0 == null) goto L6;
        r0.M7(r2, r3);
        return;
    }

    public void PP(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
    }
}
