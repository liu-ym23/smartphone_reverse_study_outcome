package com.larus.uaigc.createpage.component.mediaselector;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent;
import com.larus.uaigc.createpage.component.mediaselector.imageselector.TransparentSelectorComponent;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import lz9.b;
import lz9.c;
import ry9.g;
import ry9.j;
import sy9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010!H\u0096@¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\u0018\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/MediaSelectorContainerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMediaSelectorContainerAbility;", "<init>", "()V", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "instructionType", "", "getInstructionType", "()Ljava/lang/Integer;", "instructionType$delegate", "Lkotlin/Lazy;", "imageSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "getImageSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "imageSelectorAbility$delegate", "mediaSelectorStatus", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorStatus;", "getMediaSelectorStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "onCreate", "", "onAttach", "onViewCreated", "view", "Landroid/view/View;", "getSendAttachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markUploadHandoffToSend", "fileIdentifier", "", "cancelResourceAccessForPageLeave", "collectInstructionItemData", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "forceNotEmpty", "", "getContentComponentType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaSelectorContainerComponent extends BaseContentWidget implements g {
    public static final /* synthetic */ int o = 0;
    public final Lazy m;
    public final Lazy n;

    @Override // ry9.g
    public final i1<j> D20() {
        Integer r0 = (Integer) this.m.getValue();
        a r1 = (a) this.n.getValue();
        if (r1 == null) goto L5;
        i1<j> r2 = r1.D20();
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        return j1.a(j.b.b);
    L5:
        r2 = null;
        goto L6
    }

    @Override // ry9.g
    public final void N6() {
        a r0 = (a) this.n.getValue();
        if (r0 == null) goto L6;
        r0.N6();
        return;
    }

    public final BaseContentWidget Y2() {
        Integer r0 = (Integer) this.m.getValue();
        if (r0 != null) goto L6;
    L7:
        if (r0 != null) goto L10;
    L11:
        if (r0 != null) goto L14;
    L15:
        if (r0 != null) goto L18;
    L20:
        if (r0 != null) goto L23;
    L25:
        return null;
    L23:
        if (r0.intValue() != 28) goto L25;
        return new TransparentSelectorComponent();
    L18:
        if (r0.intValue() != 24) goto L20;
    L27:
        return new ImageSelectorComponent();
    L14:
        if (r0.intValue() == 18) goto L27;
    L10:
        if (r0.intValue() == 16) goto L27;
    L6:
        if (r0.intValue() == 4) goto L27;
        goto L7
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, g.class);
    }

    public MediaSelectorContainerComponent() {
        this.m = LazyKt.lazy(new lz9.a(this));
        this.n = LazyKt.lazy(new b(this));
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        k1a.b.b(this, new c(this));
    }

    @Override // ry9.g
    public final void C2(String r2) {
        a r0 = (a) this.n.getValue();
        if (r0 == null) goto L6;
        r0.C2(r2);
        return;
    }

    @Override // ry9.g
    public final Object Zt(Continuation<? super AttachmentInfo> r2) {
        a r0 = (a) this.n.getValue();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.Zt(r2);
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (Y2() != null) goto L8;
        FrameLayout r3 = (FrameLayout) F2().findViewById(2131379825);
        if (r3 == null) goto L9;
        e1.o(r3);
        return;
    L9:
        return;
    }

    @Override // ry9.g
    public final List<u> th(boolean r2) {
        a r0 = (a) this.n.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.th(r2);
    }
}
