package com.larus.uaigc.createpage.component.videogenerate;

import android.graphics.Bitmap;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.actionbar.model.w;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020%H\u0002J\u0012\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/larus/uaigc/createpage/component/videogenerate/VideoGenerateComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "ratioAutoSelectStrategy", "Lcom/larus/uaigc/createpage/component/videogenerate/RatioAutoSelectStrategy;", "currentSelectedDurationId", "", "Ljava/lang/Long;", "ratioSelectionStrategy", "Lcom/larus/uaigc/createpage/component/videogenerate/RatioSelectionStrategy;", "getRatioSelectionStrategy", "()Lcom/larus/uaigc/createpage/component/videogenerate/RatioSelectionStrategy;", "ratioSelectionStrategy$delegate", "Lkotlin/Lazy;", "imageSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "getImageSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "imageSelectorAbility$delegate", "multiAttachmentSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "getMultiAttachmentSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "multiAttachmentSelectorAbility$delegate", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "onCreate", "", "onStart", "interceptRatioDropDownSelectorClickEvent", "select15s", "", "hasAnyImgAndVideoButNotAvatarAttachment", "hasVideoAttachment", "bindObservers", "autoSelectRatio", "curBitmap", "Landroid/graphics/Bitmap;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VideoGenerateComponent extends ComponentFeature {
    public final c h;
    public Long i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;

    public final ys8.a L2() {
        return (ys8.a) this.m.getValue();
    }

    public final sy9.a N2() {
        return (sy9.a) this.k.getValue();
    }

    public final void onCreate() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new VideoGenerateComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new VideoGenerateComponent$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new VideoGenerateComponent$bindObservers$3(this, null), 3, null);
        ys8.a r1 = L2();
        if (r1 == null) goto L5;
        r1.setRatioDropDownSelectorClickInterceptor(new j(this));
    L5:
        ys8.a r2 = L2();
        if (r2 == null) goto L9;
        r2.setVideoModelDropDownSelectorClickInterceptor(new k(this));
        return;
    }

    public final void onStart() {
        c r0 = this.h;
        ys8.a r1 = L2();
        if (r1 == null) goto L5;
        List<w> r2 = r1.getRatioOptionList();
    L6:
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        r0.a(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public VideoGenerateComponent() {
        this.h = new c();
        this.j = LazyKt.lazy(new e(this));
        this.k = LazyKt.lazy(new f(this));
        this.l = LazyKt.lazy(new g(this));
        this.m = LazyKt.lazy(new h(this));
        this.n = LazyKt.lazy(new i(this));
    }

    public final boolean P2() {
        sy9.a r0 = N2();
        sy9.b r1 = null;
        if (r0 == null) goto L7;
        i1<sy9.b> r2 = r0.getUiState();
        if (r2 == null) goto L7;
        sy9.b r3 = (sy9.b) r2.getValue();
    L9:
        if ((r3 instanceof sy9.b.c) == true) goto L27;
        sy9.a r4 = N2();
        if (r4 == null) goto L15;
        i1<sy9.b> r5 = r4.getUiState();
        if (r5 == null) goto L15;
        sy9.b r6 = (sy9.b) r5.getValue();
    L17:
        if ((r6 instanceof sy9.b.e) == true) goto L27;
        sy9.a r7 = N2();
        if (r7 == null) goto L24;
        i1<sy9.b> r8 = r7.getUiState();
        if (r8 == null) goto L24;
        r1 = (sy9.b) r8.getValue();
    L24:
        if ((r1 instanceof sy9.b.C0075b) == true) goto L27;
        boolean r9 = false;
    L28:
        ry9.h r10 = (ry9.h) this.l.getValue();
        if (r10 == null) goto L37;
        LiveData<Map<String, ry9.k>> r11 = r10.ja();
        if (r11 == null) goto L37;
        Map r12 = (Map) r11.getValue();
        if (r12 == null) goto L37;
        if ((!r12.values().isEmpty()) != true) goto L37;
        boolean r13 = true;
    L38:
        if (r9 == true) goto L42;
        if (r13 == true) goto L42;
        boolean r14 = false;
    L43:
        if (r14 == true) goto L45;
        return false;
    L45:
        ry9.h r15 = (ry9.h) this.l.getValue();
        if (r15 == null) goto L65;
        LiveData<Map<String, ry9.k>> r16 = r15.ja();
        if (r16 == null) goto L65;
        Map r17 = (Map) r16.getValue();
        if (r17 == null) goto L65;
        Collection r18 = r17.values();
        if ((r18 instanceof Collection) == true) goto L54;
    L56:
        Iterator r19 = r18.iterator();
    L58:
        if (r19.hasNext() == false) goto L62;
        if (((ry9.k) r19.next()).e == false) goto L58;
        boolean r20 = true;
    L63:
        if (r20 != true) goto L65;
        boolean r21 = true;
    L66:
        if (r14 == false) goto L69;
        if (r21 == true) goto L69;
        return true;
    L69:
        return false;
    L62:
        r20 = false;
        goto L63
    L54:
        if (r18.isEmpty() == false) goto L56;
    L65:
        r21 = false;
    L42:
        r14 = true;
    L37:
        r13 = false;
    L15:
        r6 = null;
    L27:
        r9 = true;
    L7:
        r3 = null;
        goto L9
    }

    public static final void F2(VideoGenerateComponent r2, Bitmap r3) {
        ((d) r2.j.getValue()).a(r3, r2.L2(), r2.h);
    }
}
