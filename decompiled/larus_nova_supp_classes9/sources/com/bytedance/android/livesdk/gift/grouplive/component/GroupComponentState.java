package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupComponentState extends MVIState<GroupComponentState> {
    public static final /* synthetic */ KProperty[] j = null;
    public final r a;
    public final r b;
    public final r c;
    public final r d;
    public final r e;
    public final r f;
    public final r g;
    public final r h;
    public final r i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/grouplive/component/GroupComponentState$Mode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "EXPAND", "CLOSE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {
        public static final Mode CLOSE = null;
        public static final Mode EXPAND = null;
        public static final /* synthetic */ Mode[] a = null;
        private final int value;

        static {
            Mode r1 = new Mode("EXPAND", 0, 1);
            EXPAND = r1;
            Mode r2 = new Mode("CLOSE", 1, 0);
            CLOSE = r2;
            a = new Mode[]{r1, r2};
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Mode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/grouplive/component/GroupComponentState$Style;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "HORIZONTAL", "VERTICAL", "DEFAULT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style DEFAULT = null;
        public static final Style HORIZONTAL = null;
        public static final Style VERTICAL = null;
        public static final /* synthetic */ Style[] a = null;
        private final String value;

        static {
            Style r1 = new Style("HORIZONTAL", 0, "horizontal");
            HORIZONTAL = r1;
            Style r2 = new Style("VERTICAL", 1, "vertical");
            VERTICAL = r2;
            Style r3 = new Style("DEFAULT", 2, "default");
            DEFAULT = r3;
            a = new Style[]{r1, r2, r3};
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Style(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        j = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "enableDrag", "getEnableDrag()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "showStyle", "getShowStyle()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "mode", "getMode()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "position", "getPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "showUrl", "getShowUrl()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "payload", "getPayload()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "placeHolderHeight", "getPlaceHolderHeight()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "visibility", "getVisibility()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GroupComponentState.class, "isAnchorSide", "isAnchorSide()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public GroupComponentState() {
        Boolean r0 = Boolean.FALSE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        r r1 = new r(r0, r2, r3);
        KCallable[] r4 = j;
        ((com.bytedance.android.anya.internal.c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.a = r1;
        Style r5 = Style.DEFAULT;
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        r r8 = new r(r5, r6, r7);
        ((com.bytedance.android.anya.internal.c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.b = r8;
        Mode r9 = Mode.EXPAND;
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r11 = ((MVIState) this).propertyAddedCallback;
        r r13 = new r(r9, r10, r11);
        ((com.bytedance.android.anya.internal.c) r13).a = r4[2].getName();
        r11.invoke(r13);
        this.c = r13;
        ty1.c r14 = new ty1.c(0);
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        r r17 = new r(r14, r15, r16);
        ((com.bytedance.android.anya.internal.c) r17).a = r4[3].getName();
        r16.invoke(r17);
        this.d = r17;
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        r r20 = new r(BuildConfig.FLAVOR, r18, r19);
        ((com.bytedance.android.anya.internal.c) r20).a = r4[4].getName();
        r19.invoke(r20);
        this.e = r20;
        Function1 r21 = ((MVIState) this).propertyChangeCallback;
        Function1 r23 = ((MVIState) this).propertyAddedCallback;
        r r24 = new r(BuildConfig.FLAVOR, r21, r23);
        ((com.bytedance.android.anya.internal.c) r24).a = r4[5].getName();
        r23.invoke(r24);
        this.f = r24;
        Function1 r25 = ((MVIState) this).propertyChangeCallback;
        Function1 r26 = ((MVIState) this).propertyAddedCallback;
        r r27 = new r(234, r25, r26);
        ((com.bytedance.android.anya.internal.c) r27).a = r4[6].getName();
        r26.invoke(r27);
        this.g = r27;
        Boolean r28 = Boolean.TRUE;
        Function1 r29 = ((MVIState) this).propertyChangeCallback;
        Function1 r30 = ((MVIState) this).propertyAddedCallback;
        r r31 = new r(r28, r29, r30);
        ((com.bytedance.android.anya.internal.c) r31).a = r4[7].getName();
        r30.invoke(r31);
        this.h = r31;
        Function1 r33 = ((MVIState) this).propertyChangeCallback;
        Function1 r34 = ((MVIState) this).propertyAddedCallback;
        r r35 = new r(r0, r33, r34);
        ((com.bytedance.android.anya.internal.c) r35).a = r4[8].getName();
        r34.invoke(r35);
        this.i = r35;
    }
}
