package com.larus.uaigc.bean.chat.template;

import bq8.a;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import my9.b;
import my9.c;
import my9.d;
import my9.e;
import my9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007J\u001c\u0010\r\u001a\u00020\b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u001a\u0010\u000f\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nJ\u001c\u0010\u0011\u001a\u00020\b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006J\u001a\u0010\u0012\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/uaigc/bean/chat/template/TemplateChooseState;", "<init>", "()V", "chooseImageTemplate", "Lkotlin/Function1;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "", "chooseMusicTemplate", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "setChooseImageTemplate", "template", "listenToImageTemplate", "listener", "clearImageTemplateListener", "setChooseMusicTemplate", "listenToMusicTemplate", "clearMusicTemplateListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TemplateViewModel extends ComponentViewModel<TemplateChooseState> {
    private Function1<? super TemplateInfo$TemplateInfo, Unit> chooseImageTemplate;
    private Function1<? super a, Unit> chooseMusicTemplate;

    public static /* synthetic */ Unit No(TemplateInfo$TemplateInfo r0) {
        return chooseImageTemplate$lambda$0(r0);
    }

    public static /* synthetic */ Unit Oo(a r0) {
        return chooseMusicTemplate$lambda$1(r0);
    }

    public static /* synthetic */ Unit Po(TemplateInfo$TemplateInfo r0) {
        return clearImageTemplateListener$lambda$3(r0);
    }

    public static /* synthetic */ Unit Qo(a r0) {
        return listenToMusicTemplate$lambda$4(r0);
    }

    public static /* synthetic */ Unit So(a r0) {
        return clearMusicTemplateListener$lambda$5(r0);
    }

    public static /* synthetic */ Unit To(TemplateInfo$TemplateInfo r0) {
        return listenToImageTemplate$lambda$2(r0);
    }

    public TemplateViewModel() {
        this.chooseImageTemplate = new my9.a();
        this.chooseMusicTemplate = new b();
    }

    private static final Unit chooseImageTemplate$lambda$0(TemplateInfo$TemplateInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit chooseMusicTemplate$lambda$1(a r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit clearImageTemplateListener$lambda$3(TemplateInfo$TemplateInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit clearMusicTemplateListener$lambda$5(a r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit listenToImageTemplate$lambda$2(TemplateInfo$TemplateInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit listenToMusicTemplate$lambda$4(a r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    public final void clearImageTemplateListener(Function1<? super TemplateInfo$TemplateInfo, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.chooseImageTemplate != r2) goto L6;
        this.chooseImageTemplate = new c();
        return;
    }

    public final void clearMusicTemplateListener(Function1<? super a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.chooseMusicTemplate != r2) goto L6;
        this.chooseMusicTemplate = new f();
        return;
    }

    public final void listenToImageTemplate(Function1<? super TemplateInfo$TemplateInfo, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.chooseImageTemplate = r2;
    }

    public final void listenToMusicTemplate(Function1<? super a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.chooseMusicTemplate = r2;
    }

    public final void setChooseImageTemplate(TemplateInfo$TemplateInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "template");
        this.chooseImageTemplate.invoke(r2);
    }

    public final void setChooseMusicTemplate(a r2) {
        Intrinsics.checkNotNullParameter(r2, "template");
        this.chooseMusicTemplate.invoke(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void listenToImageTemplate$default(TemplateViewModel r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new e();
    L5:
        r0.listenToImageTemplate(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void listenToMusicTemplate$default(TemplateViewModel r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new d();
    L5:
        r0.listenToMusicTemplate(r1);
    }
}
