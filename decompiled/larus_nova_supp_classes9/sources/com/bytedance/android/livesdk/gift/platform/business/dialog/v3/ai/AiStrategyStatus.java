package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.ai;

import com.bytedance.bdlocation.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/ai/AiStrategyStatus;", BuildConfig.FLAVOR, "Companion", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AiStrategyStatus {
    public static final a Companion = null;
    public static final String NO_EFFECT_SCENE = "no_effect_scene";
    public static final String NO_STRATEGY = "no_strategy";
    public static final String STRATEGY_AND_INSERT = "strategy_and_insert";
    public static final String STRATEGY_NOT_INSERT = "strategy_not_insert";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }
}
