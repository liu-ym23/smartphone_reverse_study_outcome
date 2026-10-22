package ic8;

import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public static boolean a(Message r4) {
        if (com.larus.im.bean.message.a.b0(r4) == false) goto L5;
    L19:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List r5 = vd9.r.a(r4);
        if ((r5 instanceof Collection) == true) goto L22;
    L24:
        Iterator r6 = r5.iterator();
    L26:
        if (r6.hasNext() == false) goto L43;
        BlockContent r0 = ((Block) r6.next()).getContent();
        if (r0 == null) goto L30;
        CreationBlock r1 = r0.getCreationBlock();
    L31:
        if (r1 == null) goto L33;
        boolean r2 = true;
    L34:
        if (r2 == false) goto L26;
        return true;
    L33:
        r2 = false;
        goto L34
    L30:
        r1 = null;
        goto L31
    L43:
        return false;
    L22:
        if (r5.isEmpty() == false) goto L24;
        return false;
    L5:
        if (r4.getContentType() == 9999) goto L19;
        if (com.larus.bmhome.chat.bean.d.a0(r4) == false) goto L11;
        return true;
    L11:
        if (r4.getContentType() != 2021) goto L14;
        return true;
    L14:
        if (r4.getContentType() == 6) goto L16;
    L18:
        return false;
    L16:
        if (com.larus.bmhome.chat.bean.d.j1(r4) == false) goto L18;
        return true;
    }

    public static String b(Message r5, String r6) {
        Object r0 = null;
        if (r5 != null) goto L34;
        return null;
    L34:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        if (com.larus.bmhome.chat.bean.d.l0(r5) == false) goto L9;
        String r7 = "homework_answer_action";
    L21:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L23
    L25:
        Throwable r2 = Result.exceptionOrNull-impl(r8);
        if (r2 == null) goto L29;
        FLogger.a.e("ActionSceneResolver", "resolve failed: " + r5, r2);
    L29:
        if (Result.isFailure-impl(r8) == true) goto L33;
        r0 = r8;
    L33:
        return (String) r0;
    L9:
        if (a(r5) == false) goto L11;
        r7 = "creativity_answer_action";
        goto L21
    L11:
        u.a.getClass();     // Catch: Throwable -> L23
        UplinkFileEntity r9 = u.b(r5, r6);     // Catch: Throwable -> L23
        if (r9 != null) goto L15;
        r7 = null;
        goto L21
    L15:
        if (n1.d(r9) == false) goto L17;
    L20:
        r7 = "video_img_question_action";
        goto L21
    L17:
        if (n1.e(r9) == true) goto L20;
        r7 = "file_question_action";
    L23:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }
}
