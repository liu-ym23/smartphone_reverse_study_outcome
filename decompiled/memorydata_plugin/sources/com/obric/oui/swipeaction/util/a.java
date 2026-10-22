package com.obric.oui.swipeaction.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/swipeaction/util/RubberBandHelper;", "", "()V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0779a f14517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f14518b = 0.0f;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.util.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/swipeaction/util/RubberBandHelper$Companion;", "", "()V", "coeff", "", "getRealValue", CommonConsts.APM_INNER_EVENT_COST_START, TypedValues.AttributesType.S_TARGET, "cur", "new", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0779a {
        private C0779a() {
        }

        public /* synthetic */ C0779a(DefaultConstructorMarker r1) {
            this();
        }

        public final float a(float r4, float r5, float r6, float r7) {
            boolean r0 = true;
            if (r6 != r7) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L8;
        L31:
            return r6;
        L8:
            if (r6 != r5) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == true) goto L31;
            if (r4 >= r5) goto L19;
            if (r7 >= r4) goto L19;
            return r7;
        L19:
            if (r4 > r5) goto L21;
        L23:
            float r9 = r5 - r4;
            float r10 = ((a.a() * (r7 - r4)) / r9) + 1.0f;
            if (r10 == 0.0f) goto L27;
            r0 = false;
        L27:
            if (r0 == false) goto L30;
            return 0.0f;
        L30:
            return r4 + ((1.0f - (1.0f / r10)) * r9);
        L21:
            if (r7 <= r4) goto L23;
            return r7;
        L10:
            r8 = false;
            goto L11
        L5:
            r3 = false;
            goto L6
        }
    }

    static {
        f14517a = new C0779a(null);
        f14518b = 1.0f;
    }

    public static final /* synthetic */ float a() {
        return f14518b;
    }
}
