package com.ss.android.lark.guide.ui.config;

import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AnchorConfig {
    public final WeakReference<? extends View> a;
    public final AnchorGravity b;
    public final Point c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/guide/ui/config/AnchorConfig$AnchorGravity;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "START", "END", "TOP", "BOTTOM", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum AnchorGravity extends Enum<AnchorGravity> {
        public static final AnchorGravity BOTTOM = null;
        public static final AnchorGravity END = null;
        public static final AnchorGravity START = null;
        public static final AnchorGravity TOP = null;
        public static final /* synthetic */ AnchorGravity[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<AnchorGravity> getEntries() {
            return b;
        }

        static {
            AnchorGravity r0 = new AnchorGravity("START", 0, 8388611);
            START = r0;
            AnchorGravity r1 = new AnchorGravity("END", 1, 8388613);
            END = r1;
            AnchorGravity r2 = new AnchorGravity("TOP", 2, 48);
            TOP = r2;
            AnchorGravity r4 = new AnchorGravity("BOTTOM", 3, 80);
            BOTTOM = r4;
            AnchorGravity[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static AnchorGravity[] values() {
            return (AnchorGravity[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AnchorGravity valueOf(String r1) {
            return (AnchorGravity) a.a(AnchorGravity.class, r1);
        }

        public AnchorGravity(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ AnchorConfig(View r2, AnchorGravity r3) {
        this(r2, r3, new Point());
    }

    public AnchorConfig(View r2, AnchorGravity r3, Point r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        Intrinsics.checkNotNullParameter(r3, "anchorDirect");
        Intrinsics.checkNotNullParameter(r4, "anchorOffset");
        this.a = new WeakReference(r2);
        this.b = r3;
        this.c = r4;
    }
}
