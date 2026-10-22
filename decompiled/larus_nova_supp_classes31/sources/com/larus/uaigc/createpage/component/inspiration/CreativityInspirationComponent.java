package com.larus.uaigc.createpage.component.inspiration;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\rH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0018\u0010\u000fR\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b \u0010\u001dR\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00100R\u001c\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u00109\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00108R\u001c\u0010;\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u00108R\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u00108¨\u0006?"}, d2 = {"Lcom/larus/uaigc/createpage/component/inspiration/CreativityInspirationComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/uaigc/createpage/component/inspiration/ICreativityInspirationAbility;", "<init>", "()V", "viewModel", "Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationViewModel;", "getViewModel", "()Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "langCode", "", "getLangCode", "()Ljava/lang/String;", "langCode$delegate", "Lkotlin/Lazy;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "botId", "getBotId", "botId$delegate", "imgInspirationWithImg2ImgCache", "Lcom/larus/bmhome/instruction/repo/ImgInspirePromptData;", "getImgInspirationWithImg2ImgCache", "()Lcom/larus/bmhome/instruction/repo/ImgInspirePromptData;", "imgInspirationWithImg2ImgCache$delegate", "imgInspirationWithText2ImgCache", "getImgInspirationWithText2ImgCache", "imgInspirationWithText2ImgCache$delegate", "onAttach", "", "requestCreativityInspiration", "scene", "", "method", "hasFace", "", "requestFaceDetected", "imageUri", "imgInspirationState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationState;", "getImgInspirationState", "()Lkotlinx/coroutines/flow/StateFlow;", "imgFaceDetectedState", "Lcom/larus/uaigc/createpage/component/inspiration/ImageFaceDetectState;", "getImgFaceDetectedState", "imgInspirationPromptsWithText2ImgCache", "", "Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "getImgInspirationPromptsWithText2ImgCache", "()Ljava/util/List;", "imgInspirationPromptsWithImg2ImgCache", "getImgInspirationPromptsWithImg2ImgCache", "imgInspirationSupportInstructionTypesWithText2ImgCache", "getImgInspirationSupportInstructionTypesWithText2ImgCache", "imgInspirationSupportInstructionTypesWithImg2ImgCache", "getImgInspirationSupportInstructionTypesWithImg2ImgCache", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreativityInspirationComponent extends ComponentFeature implements f {
    public final com.larus.ui.arch.vm.internal.l h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;

    public static final class a implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public a(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class b implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class c implements Function0<ViewModelProvider.Factory> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public final ImageInspirationViewModel F2() {
        return (ImageInspirationViewModel) this.h.getValue();
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final List<fq8.e> PH() {
        fq8.f r0 = (fq8.f) this.m.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final List<Integer> XV() {
        fq8.f r0 = (fq8.f) this.m.getValue();
        if (r0 == null) goto L9;
        Map r1 = r0.a();
        if (r1 == null) goto L9;
        Set r2 = r1.keySet();
        if (r2 == null) goto L9;
        return CollectionsKt.toList(r2);
    L9:
        return null;
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final List<Integer> pN() {
        fq8.f r0 = (fq8.f) this.l.getValue();
        if (r0 == null) goto L9;
        Map r1 = r0.a();
        if (r1 == null) goto L9;
        Set r2 = r1.keySet();
        if (r2 == null) goto L9;
        return CollectionsKt.toList(r2);
    L9:
        return null;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, f.class);
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final List<fq8.e> z70() {
        fq8.f r0 = (fq8.f) this.l.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public CreativityInspirationComponent() {
        this.h = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ImageInspirationViewModel.class), Reflection.getOrCreateKotlinClass(ImageInspirationState.class), new a(this), new b(this), c.a);
        this.i = LazyKt.lazy(new com.larus.uaigc.createpage.component.inspiration.a());
        this.j = LazyKt.lazy(new com.larus.uaigc.createpage.component.inspiration.b(this));
        this.k = LazyKt.lazy(new com.larus.uaigc.createpage.component.inspiration.c(this));
        this.l = LazyKt.lazy(new d(this));
        this.m = LazyKt.lazy(new e(this));
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final i1<ImageInspirationState> U30() {
        return F2().getImgInspirationState();
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final i1<g> nl() {
        return F2().getImgFaceDetectedState();
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final void tC(String r10) {
        Intrinsics.checkNotNullParameter(r10, "imageUri");
        FLogger.a.i("CreativityInspirationComponent", "requestFaceDetected,imageUri:".concat(r10));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreativityInspirationComponent$requestFaceDetected$1(this, r10, null), 3, null);
    }

    @Override // com.larus.uaigc.createpage.component.inspiration.f
    public final void JL(int r11, boolean r12) {
        FLogger.a.i("CreativityInspirationComponent", "requestCreativityInspiration,scene:" + r11 + ",method:2,hasFace:" + r12);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreativityInspirationComponent$requestCreativityInspiration$1(this, r11, 2, r12, null), 3, null);
    }
}
