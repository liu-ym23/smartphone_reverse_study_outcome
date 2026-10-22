package com.larus.bmhome.chat.component.doubletab;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import t1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface IChatDoubleTabAbility extends a {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/component/doubletab/IChatDoubleTabAbility$BizType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BizType {
        public static final int AI_ARTIST = 1;
        public static final int AI_MUSIC = 2;
        public static final a Companion = null;
        public static final int UNKNOWN = 0;

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

    void Ui();

    int ar();

    void f0(int r1);

    int getBizType();

    String y00();
}
