package com.obric.assistant.ability.interaction;

import com.obric.aivoice.core.data.NameKeys;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlinx.coroutines.flow.MutableSharedFlow;
import m1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IRealtimeCallBridgeAbility extends a {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/ability/interaction/IRealtimeCallBridgeAbility$RealtimeCallAction;", NameKeys.UnloadStrategy_No_Strategy, "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RealtimeCallAction {
        public static final a Companion = null;
        public static final int HANG_UP = 3;
        public static final int MUTE = 1;
        public static final int UN_MUTE = 2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    MutableSharedFlow<Integer> fS();
}
