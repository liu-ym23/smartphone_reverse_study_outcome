package com.larus.avlink.simulInterpret.page.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.DoraConfig;
import ea8.w;
import ha8.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "screenMode", "Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;", "topTranslateLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "bottomTranslateLanguage", "isSiMute", "", "topTranslationResultList", "", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultItem;", "bottomTranslationResultList", "needRotated", "<init>", "(Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;Lcom/larus/avlink/simulInterpret/page/model/Language;Lcom/larus/avlink/simulInterpret/page/model/Language;ZLjava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getScreenMode", "()Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;", "getTopTranslateLanguage", "()Lcom/larus/avlink/simulInterpret/page/model/Language;", "getBottomTranslateLanguage", "()Z", "getTopTranslationResultList", "()Ljava/util/List;", "getBottomTranslationResultList", "getNeedRotated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;Lcom/larus/avlink/simulInterpret/page/model/Language;Lcom/larus/avlink/simulInterpret/page/model/Language;ZLjava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretState;", "equals", "other", "", "hashCode", "", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SimultaneousInterpretState implements w1a.b {
    public static final int $stable = 8;
    private final a bottomTranslateLanguage;
    private final List<w> bottomTranslationResultList;
    private final boolean isSiMute;
    private final Boolean needRotated;
    private final b screenMode;
    private final a topTranslateLanguage;
    private final List<w> topTranslationResultList;

    public SimultaneousInterpretState() {
        this(null, null, null, false, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SimultaneousInterpretState copy$default(SimultaneousInterpretState r5, b r6, a r7, a r8, boolean r9, List r10, List r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.screenMode;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.topTranslateLanguage;
    L8:
        a r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.bottomTranslateLanguage;
    L11:
        a r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.isSiMute;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.topTranslationResultList;
    L17:
        List r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.bottomTranslationResultList;
    L20:
        List r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.needRotated;
    L23:
        b r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final b component1() {
        return this.screenMode;
    }

    public final a component2() {
        return this.topTranslateLanguage;
    }

    public final a component3() {
        return this.bottomTranslateLanguage;
    }

    public final boolean component4() {
        return this.isSiMute;
    }

    public final List<w> component5() {
        return this.topTranslationResultList;
    }

    public final List<w> component6() {
        return this.bottomTranslationResultList;
    }

    public final Boolean component7() {
        return this.needRotated;
    }

    public final SimultaneousInterpretState copy(b r10, a r11, a r12, boolean r13, List<w> r14, List<w> r15, Boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "screenMode");
        Intrinsics.checkNotNullParameter(r11, "topTranslateLanguage");
        Intrinsics.checkNotNullParameter(r12, "bottomTranslateLanguage");
        Intrinsics.checkNotNullParameter(r14, "topTranslationResultList");
        Intrinsics.checkNotNullParameter(r15, "bottomTranslationResultList");
        return new SimultaneousInterpretState(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SimultaneousInterpretState) == true) goto L8;
        return false;
    L8:
        SimultaneousInterpretState r6 = (SimultaneousInterpretState) r5;
        if (Intrinsics.areEqual(this.screenMode, r6.screenMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topTranslateLanguage, r6.topTranslateLanguage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottomTranslateLanguage, r6.bottomTranslateLanguage) == true) goto L18;
        return false;
    L18:
        if (this.isSiMute == r6.isSiMute) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.topTranslationResultList, r6.topTranslationResultList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bottomTranslationResultList, r6.bottomTranslationResultList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.needRotated, r6.needRotated) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.screenMode.hashCode() * 31) + this.topTranslateLanguage.hashCode()) * 31) + this.bottomTranslateLanguage.hashCode()) * 31;
        if (this.isSiMute == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((((r0 + r1) * 31) + this.topTranslationResultList.hashCode()) * 31) + this.bottomTranslationResultList.hashCode()) * 31;
        Boolean r3 = this.needRotated;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "SimultaneousInterpretState(screenMode=" + this.screenMode + ", topTranslateLanguage=" + this.topTranslateLanguage + ", bottomTranslateLanguage=" + this.bottomTranslateLanguage + ", isSiMute=" + this.isSiMute + ", topTranslationResultList=" + this.topTranslationResultList + ", bottomTranslationResultList=" + this.bottomTranslationResultList + ", needRotated=" + this.needRotated + ')';
    }

    public final a getBottomTranslateLanguage() {
        return this.bottomTranslateLanguage;
    }

    public final List<w> getBottomTranslationResultList() {
        return this.bottomTranslationResultList;
    }

    public final Boolean getNeedRotated() {
        return this.needRotated;
    }

    public final b getScreenMode() {
        return this.screenMode;
    }

    public final a getTopTranslateLanguage() {
        return this.topTranslateLanguage;
    }

    public final List<w> getTopTranslationResultList() {
        return this.topTranslationResultList;
    }

    public final boolean isSiMute() {
        return this.isSiMute;
    }

    public SimultaneousInterpretState(b r2, a r3, a r4, boolean r5, List<w> r6, List<w> r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "screenMode");
        Intrinsics.checkNotNullParameter(r3, "topTranslateLanguage");
        Intrinsics.checkNotNullParameter(r4, "bottomTranslateLanguage");
        Intrinsics.checkNotNullParameter(r6, "topTranslationResultList");
        Intrinsics.checkNotNullParameter(r7, "bottomTranslationResultList");
        this.screenMode = r2;
        this.topTranslateLanguage = r3;
        this.bottomTranslateLanguage = r4;
        this.isSiMute = r5;
        this.topTranslationResultList = r6;
        this.bottomTranslationResultList = r7;
        this.needRotated = r8;
    }

    public SimultaneousInterpretState(b r6, a r7, a r8, boolean r9, List r10, List r11, Boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L14;
        if (d.a == true) goto L7;
        r6 = b.C0027b.a;
        goto L14
    L7:
        if (d.c.isEmpty() == true) goto L9;
    L11:
        r6 = b.c.a;
        goto L14
    L9:
        if (d.d.isEmpty() == false) goto L11;
        r6 = b.a.a;
    L14:
        if ((r13 & 2) == 0) goto L18;
        a r15 = a.e;
        r7 = a.C0026a.b(d.d());
        if (r7 != null) goto L18;
        r7 = a.f;
    L18:
        a r16 = r7;
        if ((r13 & 4) == 0) goto L24;
        a r17 = a.e;
        a r18 = a.C0026a.b(d.c());
        if (r18 != null) goto L23;
        r18 = a.e;
    L23:
        r8 = r18;
    L24:
        a r0 = r8;
        if ((r13 & 8) == 0) goto L27;
        r9 = DoraConfig.a.getBoolean("key_si_mute", false);
    L27:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L30;
        r10 = CollectionsKt.emptyList();
    L30:
        List r2 = r10;
        if ((r13 & 32) == 0) goto L33;
        r11 = CollectionsKt.emptyList();
    L33:
        List r3 = r11;
        if ((r13 & 64) == 0) goto L36;
        r12 = null;
    L36:
        b r19 = r6;
        this(r19, r16, r0, r1, r2, r3, r12);
    }
}
