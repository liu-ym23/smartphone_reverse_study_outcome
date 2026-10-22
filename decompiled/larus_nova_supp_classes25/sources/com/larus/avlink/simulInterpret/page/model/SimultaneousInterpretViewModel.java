package com.larus.avlink.simulInterpret.page.model;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ea8.c;
import ea8.e;
import ea8.f;
import ea8.g;
import ea8.h;
import ea8.i;
import ea8.j;
import ea8.k;
import ea8.l;
import ea8.m;
import ea8.n;
import ea8.o;
import ea8.p;
import ea8.q;
import ea8.r;
import ea8.s;
import ea8.t;
import ea8.u;
import ea8.v;
import ea8.w;
import ea8.x;
import ha8.d;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u001e\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u00020\fH\u0002J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007J\u0016\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretState;", "<init>", "()V", "topTranslationResultWorkList", "", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultItem;", "bottomTranslationResultWorkList", "languagesLoaded", "", "loadLanguagesFromConfigIfNeeded", "", "loadHistoryResult", "updateScreenMode", "mode", "Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;", "clear", "switchLanguage", "dstLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "srcLanguage", "swapLanguages", "updateTopTranslationResult", "sentence", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultSentence;", "updateBottomTranslationResult", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "forceReplaceTopTranslationResult", "item", "forceReplaceBottomTranslationResult", "toggleMuteState", "setRotatedStatus", "isRotated", "getTopLanguage", "getBottomLanguage", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SimultaneousInterpretViewModel extends ComponentViewModel<SimultaneousInterpretState> {
    public static final int $stable = 8;
    private final List<w> bottomTranslationResultWorkList;
    private boolean languagesLoaded;
    private final List<w> topTranslationResultWorkList;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TextType.values().length];
            r0[TextType.ORIGINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TextType.TRANSLATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static /* synthetic */ SimultaneousInterpretState No(com.larus.avlink.simulInterpret.page.model.a r0, com.larus.avlink.simulInterpret.page.model.a r1, SimultaneousInterpretState r2) {
        return swapLanguages$lambda$12$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ SimultaneousInterpretState Oo(com.larus.avlink.simulInterpret.page.model.a r0, com.larus.avlink.simulInterpret.page.model.a r1, SimultaneousInterpretState r2) {
        return loadLanguagesFromConfigIfNeeded$lambda$1$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ SimultaneousInterpretState Po(com.larus.avlink.simulInterpret.page.model.a r0, com.larus.avlink.simulInterpret.page.model.a r1, SimultaneousInterpretState r2) {
        return switchLanguage$lambda$10$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ SimultaneousInterpretState Qo(List r0, SimultaneousInterpretState r1) {
        return forceReplaceBottomTranslationResult$lambda$20(r0, r1);
    }

    public static /* synthetic */ Unit So(b r0, SimultaneousInterpretViewModel r1, SimultaneousInterpretState r2) {
        return updateScreenMode$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ SimultaneousInterpretState To(List r0, SimultaneousInterpretState r1) {
        return updateTopTranslationResult$lambda$14(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState Wo(com.larus.avlink.simulInterpret.page.model.a r0, SimultaneousInterpretState r1) {
        return switchLanguage$lambda$10$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit Yo(SimultaneousInterpretViewModel r0, SimultaneousInterpretState r1) {
        return toggleMuteState$lambda$22(r0, r1);
    }

    public static /* synthetic */ Unit Zo(com.larus.avlink.simulInterpret.page.model.a r0, com.larus.avlink.simulInterpret.page.model.a r1, SimultaneousInterpretViewModel r2, Ref.BooleanRef r3, SimultaneousInterpretState r4) {
        return switchLanguage$lambda$10(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit ap(com.larus.avlink.simulInterpret.page.model.a r0, com.larus.avlink.simulInterpret.page.model.a r1, SimultaneousInterpretViewModel r2, SimultaneousInterpretState r3) {
        return loadLanguagesFromConfigIfNeeded$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ SimultaneousInterpretState bp(boolean r0, SimultaneousInterpretState r1) {
        return toggleMuteState$lambda$22$lambda$21(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState cp(b r0, SimultaneousInterpretState r1) {
        return updateScreenMode$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState dp(List r0, SimultaneousInterpretState r1) {
        return forceReplaceTopTranslationResult$lambda$18(r0, r1);
    }

    public static /* synthetic */ Unit ep(SimultaneousInterpretViewModel r0, SimultaneousInterpretState r1) {
        return swapLanguages$lambda$12(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState hp(SimultaneousInterpretViewModel r0, SimultaneousInterpretState r1) {
        return loadHistoryResult$lambda$2(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState ip(List r0, SimultaneousInterpretState r1) {
        return updateBottomTranslationResult$lambda$16(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState kp(com.larus.avlink.simulInterpret.page.model.a r0, SimultaneousInterpretState r1) {
        return switchLanguage$lambda$10$lambda$8(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState lp(com.larus.avlink.simulInterpret.page.model.a r0, SimultaneousInterpretState r1) {
        return switchLanguage$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState np(boolean r0, SimultaneousInterpretState r1) {
        return setRotatedStatus$lambda$23(r0, r1);
    }

    public static /* synthetic */ SimultaneousInterpretState pp(com.larus.avlink.simulInterpret.page.model.a r0, SimultaneousInterpretState r1) {
        return switchLanguage$lambda$10$lambda$6(r0, r1);
    }

    private final void loadLanguagesFromConfigIfNeeded() {
        if (this.languagesLoaded == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.languagesLoaded = true;
        List r1 = z2.a.getDoraSimulSupportLangConfigList();
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L12;
        DeviceService r3 = r2.device();
        if (r3 == null) goto L12;
        if (r3.b0() != true) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        String r5 = DoraConfig.d();
    L16:
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L23;
        DeviceService r7 = r6.device();
        if (r7 == null) goto L23;
        if (r7.b0() != true) goto L23;
    L24:
        if (r0 == false) goto L26;
        String r8 = DoraConfig.c();
    L27:
        com.larus.avlink.simulInterpret.page.model.a r9 = com.larus.avlink.simulInterpret.page.model.a.e;
        final com.larus.avlink.simulInterpret.page.model.a r10 = com.larus.avlink.simulInterpret.page.model.a.C0026a.a(r5, r1);
        if (r10 != null) goto L30;
        r10 = com.larus.avlink.simulInterpret.page.model.a.f;
    L30:
        final com.larus.avlink.simulInterpret.page.model.a r11 = com.larus.avlink.simulInterpret.page.model.a.C0026a.a(r8, r1);
        if (r11 != null) goto L33;
        r11 = com.larus.avlink.simulInterpret.page.model.a.e;
    L33:
        withState(new s(r10, r11, this));
        return;
    L26:
        r8 = DoraConfig.a();
    L23:
        r0 = false;
        goto L24
    L15:
        r5 = DoraConfig.b();
    L12:
        r4 = false;
        goto L13
    }

    private final void swapLanguages() {
        withState(new n(this));
    }

    public final void clear() {
        this.topTranslationResultWorkList.clear();
        this.bottomTranslationResultWorkList.clear();
    }

    public final void toggleMuteState() {
        withState(new u(this));
    }

    public SimultaneousInterpretViewModel() {
        this.topTranslationResultWorkList = new ArrayList();
        this.bottomTranslationResultWorkList = new ArrayList();
    }

    public final com.larus.avlink.simulInterpret.page.model.a getBottomLanguage() {
        loadLanguagesFromConfigIfNeeded();
        return ((SimultaneousInterpretState) getState()).getBottomTranslateLanguage();
    }

    public final com.larus.avlink.simulInterpret.page.model.a getTopLanguage() {
        loadLanguagesFromConfigIfNeeded();
        return ((SimultaneousInterpretState) getState()).getTopTranslateLanguage();
    }

    public final void loadHistoryResult() {
        loadLanguagesFromConfigIfNeeded();
        boolean r0 = d.a;
        CopyOnWriteArrayList<w> r1 = d.c;
        if (r1.isEmpty() == true) goto L5;
        this.topTranslationResultWorkList.addAll(r1);
    L5:
        CopyOnWriteArrayList<w> r2 = d.d;
        if (r2.isEmpty() == true) goto L8;
        this.bottomTranslationResultWorkList.addAll(r2);
    L8:
        setState(new t(this));
    }

    public final void forceReplaceTopTranslationResult(w r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        List<w> r0 = this.topTranslationResultWorkList;
        ListIterator<w> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r1.previous().a, r5.a) == false) goto L4;
        int r2 = r1.nextIndex();
    L9:
        if (r2 == (-1)) goto L15;
        ListProtector.set(this.topTranslationResultWorkList, r2, r5);
        final List r6 = CollectionsKt.toList(this.topTranslationResultWorkList);
        setState(new l(r6));
        return;
    L15:
        return;
    L8:
        r2 = -1;
        goto L9
    }

    public final void setRotatedStatus(final boolean r2) {
        setState(new j(r2));
    }

    public final void updateScreenMode(final b r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        withState(new q(r2, this));
    }

    public final void updateTopTranslationResult(x r7) {
        Intrinsics.checkNotNullParameter(r7, "sentence");
        List<w> r0 = this.topTranslationResultWorkList;
        ListIterator<w> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r1.previous().a, r7.b) == false) goto L4;
        int r2 = r1.nextIndex();
    L10:
        if (r2 == (-1)) goto L19;
        w r3 = (w) ListProtector.get(this.topTranslationResultWorkList, r2);
        int r4 = a.a[r7.getType().ordinal()];
        if (r4 == 1) goto L17;
        if (r4 != 2) goto L16;
        w r8 = w.a(r3, null, StringsKt.trim(r3.c + r7.c).toString(), 3);
    L18:
        ListProtector.set(this.topTranslationResultWorkList, r2, r8);
    L27:
        final List r9 = CollectionsKt.toList(this.topTranslationResultWorkList);
        setState(new v(r9));
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r8 = w.a(r3, StringsKt.trim(r3.b + r7.c).toString(), null, 5);
        goto L18
    L19:
        int r5 = a.a[r7.getType().ordinal()];
        if (r5 == 1) goto L25;
        if (r5 != 2) goto L24;
        w r6 = new w(r7.b, "", StringsKt.trim(r7.c).toString());
    L26:
        this.topTranslationResultWorkList.add(r6);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r6 = new w(r7.b, StringsKt.trim(r7.c).toString(), "");
        goto L26
    L8:
        r2 = -1;
        goto L10
    }

    private static final SimultaneousInterpretState forceReplaceBottomTranslationResult$lambda$20(List r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, null, false, null, r11, null, 95, null);
    }

    private static final SimultaneousInterpretState forceReplaceTopTranslationResult$lambda$18(List r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, null, false, r11, null, null, DoraCallStateCode.DOUBAO_CMD_5, null);
    }

    private static final SimultaneousInterpretState loadHistoryResult$lambda$2(SimultaneousInterpretViewModel r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, null, false, CollectionsKt.toList(r11.topTranslationResultWorkList), CollectionsKt.toList(r11.bottomTranslationResultWorkList), null, 79, null);
    }

    private static final SimultaneousInterpretState setRotatedStatus$lambda$23(boolean r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, null, false, null, null, Boolean.valueOf(r11), 63, null);
    }

    private static final Unit swapLanguages$lambda$12(SimultaneousInterpretViewModel r3, SimultaneousInterpretState r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        final com.larus.avlink.simulInterpret.page.model.a r0 = r4.getTopTranslateLanguage();
        final com.larus.avlink.simulInterpret.page.model.a r5 = r4.getBottomTranslateLanguage();
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L9;
        DeviceService r2 = r1.device();
        if (r2 == null) goto L9;
        boolean r6 = true;
        if (r2.b0() != true) goto L9;
    L10:
        if (r6 == false) goto L12;
        Keva r7 = DoraConfig.a;
        DoraConfig.k(r5.b);
        DoraConfig.j(r0.b);
    L13:
        r3.setState(new r(r5, r0));
        return Unit.INSTANCE;
    L12:
        Keva r8 = DoraConfig.a;
        DoraConfig.i(r5.b);
        DoraConfig.h(r0.b);
    L9:
        r6 = false;
        goto L10
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$6(com.larus.avlink.simulInterpret.page.model.a r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        com.larus.avlink.simulInterpret.page.model.a r0 = com.larus.avlink.simulInterpret.page.model.a.e;
        return SimultaneousInterpretState.copy$default(r12, null, r11, com.larus.avlink.simulInterpret.page.model.a.e, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$7(com.larus.avlink.simulInterpret.page.model.a r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, r11, null, false, null, null, null, 125, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$8(com.larus.avlink.simulInterpret.page.model.a r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        com.larus.avlink.simulInterpret.page.model.a r0 = com.larus.avlink.simulInterpret.page.model.a.e;
        return SimultaneousInterpretState.copy$default(r12, null, com.larus.avlink.simulInterpret.page.model.a.e, r11, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$9(com.larus.avlink.simulInterpret.page.model.a r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, r11, false, null, null, null, 123, null);
    }

    private static final Unit toggleMuteState$lambda$22(SimultaneousInterpretViewModel r2, SimultaneousInterpretState r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        final boolean r4 = !r3.isSiMute();
        DoraConfig.a.storeBoolean("key_si_mute", r4);
        r2.setState(new c(r4));
        return Unit.INSTANCE;
    }

    private static final SimultaneousInterpretState toggleMuteState$lambda$22$lambda$21(boolean r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, null, r11, null, null, null, 119, null);
    }

    private static final SimultaneousInterpretState updateBottomTranslationResult$lambda$16(List r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, null, false, null, r11, null, 95, null);
    }

    private static final SimultaneousInterpretState updateScreenMode$lambda$4$lambda$3(b r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, r11, null, null, false, null, null, null, 126, null);
    }

    private static final SimultaneousInterpretState updateTopTranslationResult$lambda$14(List r11, SimultaneousInterpretState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return SimultaneousInterpretState.copy$default(r12, null, null, null, false, r11, null, null, DoraCallStateCode.DOUBAO_CMD_5, null);
    }

    public final void forceReplaceBottomTranslationResult(w r5, DoraDeviceType r6) {
        Intrinsics.checkNotNullParameter(r5, "item");
        Intrinsics.checkNotNullParameter(r6, "deviceType");
        List<w> r0 = this.bottomTranslationResultWorkList;
        ListIterator<w> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r1.previous().a, r5.a) == false) goto L4;
        int r2 = r1.nextIndex();
    L9:
        if (r2 != (-1)) goto L11;
        return;
    L11:
        if (r6 != DoraDeviceType.DEVICE_LITE) goto L13;
        ListProtector.set(this.bottomTranslationResultWorkList, r2, r5);
    L14:
        final List r7 = CollectionsKt.toList(this.bottomTranslationResultWorkList);
        setState(new k(r7));
        return;
    L13:
        w r8 = w.a((w) ListProtector.get(this.bottomTranslationResultWorkList, r2), null, StringsKt.trim(r5.c).toString(), 3);
        ListProtector.set(this.bottomTranslationResultWorkList, r2, r8);
        goto L14
    L8:
        r2 = -1;
        goto L9
    }

    public final boolean switchLanguage(final com.larus.avlink.simulInterpret.page.model.a r3, final com.larus.avlink.simulInterpret.page.model.a r4) {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        withState(new o(r3, r4, this, r0));
        return r0.element;
    }

    public final void updateBottomTranslationResult(x r6, DoraDeviceType r7) {
        Intrinsics.checkNotNullParameter(r6, "sentence");
        Intrinsics.checkNotNullParameter(r7, "deviceType");
        List<w> r8 = this.bottomTranslationResultWorkList;
        ListIterator<w> r9 = r8.listIterator(r8.size());
    L4:
        if (r9.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r9.previous().a, r6.b) == false) goto L4;
        int r10 = r9.nextIndex();
    L10:
        if (r10 == (-1)) goto L19;
        w r1 = (w) ListProtector.get(this.bottomTranslationResultWorkList, r10);
        int r3 = a.a[r6.getType().ordinal()];
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        w r11 = w.a(r1, null, StringsKt.trim(r1.c + r6.c).toString(), 3);
    L18:
        ListProtector.set(this.bottomTranslationResultWorkList, r10, r11);
    L27:
        final List r12 = CollectionsKt.toList(this.bottomTranslationResultWorkList);
        setState(new p(r12));
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r11 = w.a(r1, StringsKt.trim(r1.b + r6.c).toString(), null, 5);
        goto L18
    L19:
        int r13 = a.a[r6.getType().ordinal()];
        if (r13 == 1) goto L25;
        if (r13 != 2) goto L24;
        w r14 = new w(r6.b, "", StringsKt.trim(r6.c).toString());
    L26:
        this.bottomTranslationResultWorkList.add(r14);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r14 = new w(r6.b, StringsKt.trim(r6.c).toString(), "");
        goto L26
    L8:
        r10 = -1;
        goto L10
    }

    private static final SimultaneousInterpretState loadLanguagesFromConfigIfNeeded$lambda$1$lambda$0(com.larus.avlink.simulInterpret.page.model.a r11, com.larus.avlink.simulInterpret.page.model.a r12, SimultaneousInterpretState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        return SimultaneousInterpretState.copy$default(r13, null, r11, r12, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState swapLanguages$lambda$12$lambda$11(com.larus.avlink.simulInterpret.page.model.a r11, com.larus.avlink.simulInterpret.page.model.a r12, SimultaneousInterpretState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        return SimultaneousInterpretState.copy$default(r13, null, r11, r12, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$5(com.larus.avlink.simulInterpret.page.model.a r11, com.larus.avlink.simulInterpret.page.model.a r12, SimultaneousInterpretState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        return SimultaneousInterpretState.copy$default(r13, null, r11, r12, false, null, null, null, 121, null);
    }

    private static final Unit updateScreenMode$lambda$4(final b r1, SimultaneousInterpretViewModel r2, SimultaneousInterpretState r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (Intrinsics.areEqual(r3.getScreenMode(), r1) == true) goto L6;
        r2.setState(new m(r1));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit loadLanguagesFromConfigIfNeeded$lambda$1(final com.larus.avlink.simulInterpret.page.model.a r2, final com.larus.avlink.simulInterpret.page.model.a r3, SimultaneousInterpretViewModel r4, SimultaneousInterpretState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if (Intrinsics.areEqual(r5.getTopTranslateLanguage().b, r2.b) == true) goto L5;
    L6:
        r4.setState(new i(r2, r3));
    L8:
        return Unit.INSTANCE;
    L5:
        if (Intrinsics.areEqual(r5.getBottomTranslateLanguage().b, r3.b) == true) goto L8;
        goto L6
    }

    public static /* synthetic */ boolean switchLanguage$default(SimultaneousInterpretViewModel r1, com.larus.avlink.simulInterpret.page.model.a r2, com.larus.avlink.simulInterpret.page.model.a r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        return r1.switchLanguage(r2, r3);
    }

    private static final Unit switchLanguage$lambda$10(final com.larus.avlink.simulInterpret.page.model.a r3, final com.larus.avlink.simulInterpret.page.model.a r4, SimultaneousInterpretViewModel r5, Ref.BooleanRef r6, SimultaneousInterpretState r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        r5.swapLanguages();
    L84:
        return Unit.INSTANCE;
    L6:
        boolean r0 = true;
        boolean r1 = false;
        if (r3 == null) goto L21;
        if (r4 == null) goto L21;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L16;
        DeviceService r9 = r8.device();
        if (r9 == null) goto L16;
        if (r9.b0() != true) goto L16;
    L17:
        if (r0 == false) goto L19;
        Keva r10 = DoraConfig.a;
        DoraConfig.k(r3.b);
        DoraConfig.j(r4.b);
    L20:
        r5.setState(new ea8.d(r3, r4));
        goto L84
    L19:
        Keva r11 = DoraConfig.a;
        DoraConfig.i(r3.b);
        DoraConfig.h(r4.b);
    L16:
        r0 = false;
    L21:
        if (r3 != null) goto L23;
        if (r4 == null) goto L84;
        if (Intrinsics.areEqual(r4.b, r7.getTopTranslateLanguage().b) == false) goto L57;
        r5.swapLanguages();
        goto L84
    L57:
        if (r4.d == false) goto L59;
    L71:
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L78;
        DeviceService r13 = r12.device();
        if (r13 == null) goto L78;
        if (r13.b0() != true) goto L78;
    L79:
        if (r0 == false) goto L81;
        Keva r14 = DoraConfig.a;
        DoraConfig.j(r4.b);
    L82:
        r5.setState(new h(r4));
        goto L84
    L81:
        Keva r15 = DoraConfig.a;
        DoraConfig.h(r4.b);
    L78:
        r0 = false;
        goto L79
    L59:
        if (r7.getTopTranslateLanguage().d == true) goto L71;
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L67;
        DeviceService r17 = r16.device();
        if (r17 == null) goto L67;
        if (r17.b0() != true) goto L67;
        r1 = true;
    L67:
        if (r1 == false) goto L69;
        Keva r18 = DoraConfig.a;
        DoraConfig.j(r4.b);
        DoraConfig.k(com.larus.avlink.simulInterpret.page.model.a.e.b);
    L70:
        r5.setState(new g(r4));
        r6.element = true;
        goto L84
    L69:
        Keva r19 = DoraConfig.a;
        DoraConfig.h(r4.b);
        DoraConfig.i(com.larus.avlink.simulInterpret.page.model.a.e.b);
        goto L70
    L23:
        if (Intrinsics.areEqual(r3.b, r7.getBottomTranslateLanguage().b) == false) goto L26;
        r5.swapLanguages();
        goto L84
    L26:
        if (r3.d == false) goto L28;
    L40:
        IDoraService r20 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r20 == null) goto L47;
        DeviceService r21 = r20.device();
        if (r21 == null) goto L47;
        if (r21.b0() != true) goto L47;
    L48:
        if (r0 == false) goto L50;
        Keva r22 = DoraConfig.a;
        DoraConfig.k(r3.b);
    L51:
        r5.setState(new f(r3));
        goto L84
    L50:
        Keva r23 = DoraConfig.a;
        DoraConfig.i(r3.b);
    L47:
        r0 = false;
        goto L48
    L28:
        if (r7.getBottomTranslateLanguage().d == true) goto L40;
        IDoraService r24 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r24 == null) goto L36;
        DeviceService r25 = r24.device();
        if (r25 == null) goto L36;
        if (r25.b0() != true) goto L36;
        r1 = true;
    L36:
        if (r1 == false) goto L38;
        Keva r26 = DoraConfig.a;
        DoraConfig.k(r3.b);
        DoraConfig.j(com.larus.avlink.simulInterpret.page.model.a.e.b);
    L39:
        r5.setState(new e(r3));
        r6.element = true;
        goto L84
    L38:
        Keva r27 = DoraConfig.a;
        DoraConfig.i(r3.b);
        DoraConfig.h(com.larus.avlink.simulInterpret.page.model.a.e.b);
        goto L39
    }
}
