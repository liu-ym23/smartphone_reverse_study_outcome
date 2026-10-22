package com.larus.bmhome.chat.layout.holder.progressloading;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface ISketchLoadingController {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController$LoadingAssetType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LoadingAssetType {
        public static final a Companion = null;
        public static final int IMAGE = 1;
        public static final int VIDEO = 2;

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
        public static /* synthetic */ void a(ISketchLoadingController r1, String r2, int r3, int r4) {
            if ((r4 & 2) == 0) goto L6;
            r3 = i5.h();
        L6:
            if ((r4 & 4) == 0) goto L8;
            int r5 = i5.Y();
        L9:
            r1.a(r2, r3, r5);
            return;
        L8:
            r5 = 0;
            goto L9
        }

        public static /* synthetic */ void b(ISketchLoadingController r1, boolean r2, ImageLoadingDrawPartType r3, int r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 1;
        L11:
            r1.b(r2, r3, r4);
        }
    }

    void a(String r1, int r2, int r3);

    void b(boolean r1, ImageLoadingDrawPartType r2, int r3);

    void c(String r1);

    void hide();

    Boolean isVisible();

    void setProgress(int r1);
}
