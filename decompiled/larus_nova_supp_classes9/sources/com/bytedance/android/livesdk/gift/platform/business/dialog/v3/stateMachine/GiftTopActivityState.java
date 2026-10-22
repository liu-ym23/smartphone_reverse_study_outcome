package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007R'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopActivityState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", BuildConfig.FLAVOR, "title$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getTitle", "()Lcom/bytedance/android/anya/r0;", "title", "Lpy/k;", "titleImg$delegate", "getTitleImg", "titleImg", "text$delegate", "getText", "text", "buttonText$delegate", "getButtonText", "buttonText", "schemeUrl$delegate", "getSchemeUrl", "schemeUrl", "backgroundImg$delegate", "getBackgroundImg", "backgroundImg", "currentPageName$delegate", "getCurrentPageName", "currentPageName", "iconImage$delegate", "getIconImage", "iconImage", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PageProgressBarData;", "progressBarData$delegate", "getProgressBarData", "progressBarData", "<init>", "()V", "Companion", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopActivityState extends MVIState<GiftTopActivityState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private static final k defaultImg = null;
    private final ReadOnlyProperty backgroundImg$delegate;
    private final ReadOnlyProperty buttonText$delegate;
    private final ReadOnlyProperty currentPageName$delegate;
    private final ReadOnlyProperty iconImage$delegate;
    private final ReadOnlyProperty progressBarData$delegate;
    private final ReadOnlyProperty schemeUrl$delegate;
    private final ReadOnlyProperty text$delegate;
    private final ReadOnlyProperty title$delegate;
    private final ReadOnlyProperty titleImg$delegate;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopActivityState$Companion;", BuildConfig.FLAVOR, "Lpy/k;", "defaultImg", "Lpy/k;", "getDefaultImg", "()Lpy/k;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final k getDefaultImg() {
            return GiftTopActivityState.access$getDefaultImg$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public final r0<GiftTopActivityState, k> getBackgroundImg() {
        return (r0) this.backgroundImg$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<GiftTopActivityState, String> getButtonText() {
        return (r0) this.buttonText$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftTopActivityState, String> getCurrentPageName() {
        return (r0) this.currentPageName$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<GiftTopActivityState, k> getIconImage() {
        return (r0) this.iconImage$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final r0<GiftTopActivityState, PageProgressBarData> getProgressBarData() {
        return (r0) this.progressBarData$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final r0<GiftTopActivityState, String> getSchemeUrl() {
        return (r0) this.schemeUrl$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<GiftTopActivityState, String> getText() {
        return (r0) this.text$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftTopActivityState, String> getTitle() {
        return (r0) this.title$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftTopActivityState, k> getTitleImg() {
        return (r0) this.titleImg$delegate.getValue(this, $$delegatedProperties[1]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "title", "getTitle()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "titleImg", "getTitleImg()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "text", "getText()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "buttonText", "getButtonText()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "schemeUrl", "getSchemeUrl()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "backgroundImg", "getBackgroundImg()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "currentPageName", "getCurrentPageName()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "iconImage", "getIconImage()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopActivityState.class, "progressBarData", "getProgressBarData()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
        Companion = new Companion(null);
        defaultImg = f.c(k.class);
    }

    public GiftTopActivityState() {
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(BuildConfig.FLAVOR, r1, r2);
        KCallable[] r3 = $$delegatedProperties;
        ((c) r0).a = r3[0].getName();
        r2.invoke(r0);
        this.title$delegate = r0;
        k r4 = defaultImg;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r4, r5, r6);
        ((c) r7).a = r3[1].getName();
        r6.invoke(r7);
        this.titleImg$delegate = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        r r10 = new r(BuildConfig.FLAVOR, r8, r9);
        ((c) r10).a = r3[2].getName();
        r9.invoke(r10);
        this.text$delegate = r10;
        Function1 r11 = ((MVIState) this).propertyChangeCallback;
        Function1 r13 = ((MVIState) this).propertyAddedCallback;
        r r14 = new r(BuildConfig.FLAVOR, r11, r13);
        ((c) r14).a = r3[3].getName();
        r13.invoke(r14);
        this.buttonText$delegate = r14;
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(BuildConfig.FLAVOR, r15, r16);
        ((c) r17).a = r3[4].getName();
        r16.invoke(r17);
        this.schemeUrl$delegate = r17;
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        r r20 = new r(r4, r18, r19);
        ((c) r20).a = r3[5].getName();
        r19.invoke(r20);
        this.backgroundImg$delegate = r20;
        Function1 r21 = ((MVIState) this).propertyChangeCallback;
        Function1 r23 = ((MVIState) this).propertyAddedCallback;
        r r24 = new r("礼物", r21, r23);
        ((c) r24).a = r3[6].getName();
        r23.invoke(r24);
        this.currentPageName$delegate = r24;
        Function1 r25 = ((MVIState) this).propertyChangeCallback;
        Function1 r26 = ((MVIState) this).propertyAddedCallback;
        r r27 = new r(r4, r25, r26);
        ((c) r27).a = r3[7].getName();
        r26.invoke(r27);
        this.iconImage$delegate = r27;
        PageProgressBarData r28 = new PageProgressBarData(false, 0.0f, 0, 7, null);
        Function1 r29 = ((MVIState) this).propertyChangeCallback;
        Function1 r30 = ((MVIState) this).propertyAddedCallback;
        r r31 = new r(r28, r29, r30);
        ((c) r31).a = r3[8].getName();
        r30.invoke(r31);
        this.progressBarData$delegate = r31;
    }

    public static final /* synthetic */ k access$getDefaultImg$cp() {
        return defaultImg;
    }
}
