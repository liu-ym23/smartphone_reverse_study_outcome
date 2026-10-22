package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BgPromptGenerateViewModel implements i, h {
    public static final /* synthetic */ int q = 0;
    public final CoroutineScope a;
    public final AIGenBgImageRepository b;
    public final h c;
    public final BotImageUploadViewModel d;
    public final StateFlowImpl e;
    public final b1 f;
    public final MutableSharedFlow<e> g;
    public final a1 h;
    public Job i;
    public String j;
    public final String k;
    public volatile boolean l;
    public ImageUploadResult m;
    public boolean n;
    public boolean o;
    public final com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.h p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String a() {
        return this.c.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final void b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "doOnNext");
        this.c.b(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String c() {
        return this.c.c();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final uc9.b d() {
        return this.c.d();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String e() {
        return this.c.e();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.h
    public final String f() {
        return this.c.f();
    }

    @Override // uu8.b
    public final d1<e> getUiEvent() {
        return this.h;
    }

    @Override // uu8.b
    public final i1<f> getUiState() {
        return this.f;
    }

    @Override // uu8.b
    public final void dispatchUIAction(d r7) {
        d r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "uiAction");
        String r3 = "";
        ImageUploadResult r4 = null;
        if (Intrinsics.areEqual(r8, d.a.a) == false) goto L33;
        int r9 = ((f) this.f.getValue()).c;
        if (r9 == 0) goto L17;
        if (r9 == 1) goto L9;
        if (r9 == 2) goto L9;
        return;
    L9:
        Job r10 = this.i;
        if (r10 == null) goto L12;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
        this.i = null;
    L12:
        h(new TextRes.StringResId(2131901612), false, 0);
        uc9.b r11 = d();
        r11.a = this.j;
        String r1 = d().a;
        if (r1 == null) goto L16;
        r3 = r1;
    L16:
        i(new e.a(r3));
        qu8.b.d("gen_prompt", -1);
        return;
    L17:
        String r12 = d().a;
        if (r12 != null) goto L20;
        r12 = "";
    L20:
        this.j = r12;
        i(new e.a(""));
        if (StringsKt.isBlank(this.j) == false) goto L23;
        h(new TextRes.StringResId(2131906071), true, 1);
    L24:
        qu8.b.e("gen_prompt", "bot_create/bg_setting/ai", false);
        ImageUploadResult r13 = this.m;
        if (r13 != null) goto L27;
    L31:
        b(new g(this));
        return;
    L27:
        if (this.n == false) goto L29;
        r4 = r13;
    L29:
        if (r4 == null) goto L31;
        g(r4);
        return;
    L23:
        h(new TextRes.StringResId(2131908729), true, 2);
        goto L24
    L33:
        if (Intrinsics.areEqual(r8, d.b.a) == false) goto L42;
        this.m = null;
        this.n = true;
        if (((f) this.f.getValue()).c != 0) goto L40;
        String r0 = d().a;
        if (r0 == null) goto L40;
        r3 = r0;
    L40:
        i(new e.b(r3));
        return;
    L42:
        if ((r8 instanceof d.C0060d) == false) goto L51;
        d().a = ((d.C0060d) r8).a;
        String r2 = d().a;
        if (r2 == null) goto L47;
        r3 = r2;
    L47:
        i(new e.a(r3));
        if (this.l == true) goto L60;
        FLogger.a.d("BgPromptGenerateViewModel", "onTextChange, clear bgImgPromptEn");
        this.l = true;
        d().b = null;
        return;
    L60:
        return;
    L51:
        if (Intrinsics.areEqual(r8, d.c.a) == false) goto L55;
        this.m = null;
        this.n = false;
        return;
    L55:
        throw new NoWhenBranchMatchedException();
    }

    public final void g(ImageUploadResult r7) {
        this.i = BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new BgPromptGenerateViewModel$generatePrompt$1(this, r7, null), 2, null);
    }

    public final void i(e r7) {
        BuildersKt.launch$default(this.a, null, null, new BgPromptGenerateViewModel$sendUIEvent$1(this, r7, null), 3, null);
    }

    public final void h(TextRes.StringResId r3, boolean r4, @BgPromptEditState int r5) {
        StateFlowImpl r0 = this.e;
        ((f) this.f.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r3, "hint");
        r0.setValue(new f(r3, r4, r5));
    }

    public BgPromptGenerateViewModel(Application r2, CoroutineScope r3, AIGenBgImageRepository r4, BotBgImageGenerateViewModel.b r5) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "repo");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        BotImageUploadViewModel r6 = new BotImageUploadViewModel(r2);
        this.d = r6;
        StateFlowImpl r7 = j1.a(new f(new TextRes.StringResId(2131901612), false, 0));
        this.e = r7;
        this.f = kotlinx.coroutines.flow.e.b(r7);
        MutableSharedFlow<e> r8 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.g = r8;
        this.h = kotlinx.coroutines.flow.e.a(r8);
        this.j = "";
        this.k = "";
        this.p = new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.h();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(FlowLiveDataConversions.asFlow(r6.getUpload().c), new BgPromptGenerateViewModel$bindObservers$1(this, null)), r3);
    }
}
