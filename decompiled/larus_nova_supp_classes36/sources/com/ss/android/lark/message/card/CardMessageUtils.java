package com.ss.android.lark.message.card;

import android.text.TextUtils;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CardMessageUtils {
    public static final /* synthetic */ int a = 0;

    @Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/message/card/CardMessageUtils$RenderType;", "", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RenderType {
        public static final int CARD = 0;
        public static final int CARD_WITH_TRANSLATION = 2;
        public static final a Companion = null;
        public static final int TRANSLATION = 1;

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

    public static final class a {
        public static boolean a(CardContent r3) {
            Intrinsics.checkNotNullParameter(r3, "cardContent");
            boolean r0 = b.a().getFgValue("messagecard.translate.force_enable_translate", false);
            if (r3.getExtraInfo() == null) goto L6;
            CardContent.ExtraInfo r1 = r3.getExtraInfo();
            Intrinsics.checkNotNull(r1);
            if (r1.getEnableTranslate() == false) goto L6;
        L9:
            if (r3.getType() == CardContent.Type.TEXT) goto L12;
            return false;
        L12:
            if (r3.getCardVersion() >= 2) goto L14;
            return false;
        L14:
            return true;
        L6:
            if (r0 == true) goto L9;
            return false;
        }

        public static boolean b(f r2) {
            Intrinsics.checkNotNullParameter(r2, "contentVO");
            if (r2.f != 1) goto L6;
            return true;
        L6:
            if (r2.g != null) goto L8;
            return true;
        L8:
            if (TextUtils.isEmpty(r2.b) == true) goto L19;
            String r0 = r2.b;
            f r3 = r2.g;
            if (r3 == null) goto L12;
            String r4 = r3.b;
        L14:
            if (Intrinsics.areEqual(r0, r4) == false) goto L20;
            return false;
        L20:
            return true;
        L12:
            r4 = null;
            goto L14
        L19:
            return true;
        }
    }

    static {
    }
}
