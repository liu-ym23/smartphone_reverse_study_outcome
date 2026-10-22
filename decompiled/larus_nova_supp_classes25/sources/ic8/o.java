package ic8;

import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public static String b(UplinkFileEntity r3) {
        if (r3 == null) goto L4;
        Integer r0 = r3.getEntityType();
    L5:
        int r1 = UplinkEntityType.EntityTypeImage.getValue();
        if (r0 != null) goto L9;
    L11:
        int r2 = UplinkEntityType.EntityTypeFile.getValue();
        if (r0 != null) goto L15;
    L30:
        return "";
    L15:
        if (r0.intValue() != r2) goto L30;
        UplinkEntityContent r4 = r3.getUplinkEntityContent();
        if (r4 == null) goto L26;
        UplinkFileInfo r5 = r4.getUplinkFileInfo();
        if (r5 == null) goto L26;
        Integer r6 = r5.getFileType();
        int r7 = FileType.FileTypeVideo.getValue();
        if (r6 == null) goto L26;
        if (r6.intValue() != r7) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        return "video";
    L29:
        return "file";
    L26:
        r8 = false;
        goto L27
    L9:
        if (r0.intValue() != r1) goto L11;
        return "pic";
    L4:
        r0 = null;
        goto L5
    }

    public static UplinkFileEntity c(UplinkFileEntity r21, Map r22) {
        boolean r0 = false;
        if (r22 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        LinkedHashMap r3 = null;
        if (r2 == true) goto L47;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r5 = r22.entrySet().iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        Map.Entry r6 = (Map.Entry) r5.next();
        r4.put((String) r6.getKey(), (String) r6.getValue());
        goto L14
    L16:
        String r7 = (String) r4.get("targetMessageType");
        if (r7 != null) goto L19;
    L24:
        r7 = (String) r4.get("target_message_type");
        if (r7 != null) goto L27;
    L29:
        r7 = null;
    L30:
        CharSequence r8 = (CharSequence) r4.get("message_type");
        if (r8 != null) goto L33;
    L36:
        boolean r9 = true;
    L37:
        if (r9 == false) goto L45;
        if (r7 != null) goto L40;
    L41:
        r0 = true;
    L42:
        if (r0 == true) goto L45;
        r4.put("message_type", r7);
        goto L45
    L40:
        if (StringsKt.isBlank(r7) == false) goto L42;
    L45:
        if ((!r4.isEmpty()) == false) goto L47;
        r3 = r4;
        goto L47
    L33:
        if (StringsKt.isBlank(r8) == true) goto L36;
        r9 = false;
        goto L37
    L27:
        if ((!StringsKt.isBlank(r7)) == false) goto L29;
    L19:
        if ((!StringsKt.isBlank(r7)) == true) goto L22;
        r7 = null;
    L22:
        if (r7 == null) goto L24;
    L47:
        if (r3 != null) goto L49;
        return r21;
    L49:
        LinkedHashMap r1 = new LinkedHashMap();
        Map r10 = r21.getExtra();
        if (r10 == null) goto L55;
        Iterator r11 = r10.entrySet().iterator();
    L53:
        if (r11.hasNext() == false) goto L55;
        Map.Entry r12 = (Map.Entry) r11.next();
        r1.put((String) r12.getKey(), (String) r12.getValue());
    L55:
        Iterator r13 = r3.entrySet().iterator();
    L57:
        if (r13.hasNext() == false) goto L59;
        Map.Entry r14 = (Map.Entry) r13.next();
        r1.put((String) r14.getKey(), (String) r14.getValue());
        goto L57
    L59:
        Unit r15 = Unit.INSTANCE;
        return UplinkFileEntity.copy$default(r21, null, null, null, null, null, null, null, null, null, false, null, null, null, r1, 8191, null);
    L5:
        if (r22.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public static boolean a(View r25, Fragment r26, Message r27, String r28, UplinkFileEntity r29, String r30, Map r31, Function1 r32) {
        Intrinsics.checkNotNullParameter(r25, "anchorView");
        Intrinsics.checkNotNullParameter(r30, "fromScene");
        boolean r2 = false;
        if (r27 != null) goto L71;
        return false;
    L71:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L61
        String r5 = null;
        if (r26 == null) goto L9;
        g1 r6 = (g1) s1a.a.g(r26).getAbility(g1.class);     // Catch: Throwable -> L61
        if (r6 == null) goto L9;
    L21:
        u.a.getClass();     // Catch: Throwable -> L61
        UplinkFileEntity r3 = u.b(r27, r28);     // Catch: Throwable -> L61
        if (r3 != null) goto L24;
        r3 = r29;
    L24:
        if (r3 == null) goto L30;
        if (r32 == null) goto L31;
        UplinkFileEntity r0 = (UplinkFileEntity) r32.invoke(r3);     // Catch: Throwable -> L61
        if (r0 == null) goto L31;
        r3 = r0;
    L31:
        if (r6 == null) goto L59;
        if (r3 == null) goto L59;
        UplinkFileEntity r1 = c(r3, r31);     // Catch: Throwable -> L61
        Map r7 = r1.getExtra();     // Catch: Throwable -> L61
        if (r7 == null) goto L73;
        String r8 = (String) r7.get("creation_task_id");     // Catch: Throwable -> L61
        if (r8 == null) goto L73;
        if ((!StringsKt.isBlank(r8)) == false) goto L73;
        r5 = r8;
    L73:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r6.RD(r1, r30)));     // Catch: Throwable -> L45
    L47:
        Boolean r10 = Boolean.FALSE;     // Catch: Throwable -> L61
        if (Result.isFailure-impl(r9) == false) goto L50;
        r9 = r10;
    L50:
        r2 = ((Boolean) r9).booleanValue();     // Catch: Throwable -> L61
        LruCache r11 = ko8.a.a;     // Catch: Throwable -> L61
        String r19 = ko8.a.c(r27);     // Catch: Throwable -> L61
        String r12 = r27.getMessageId();     // Catch: Throwable -> L61
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L61
        r13.putOpt("creation_task_id", r5);     // Catch: Throwable -> L61
        boolean r14 = com.larus.bmhome.chat.bean.d.z0(r27);     // Catch: Throwable -> L61
        if (Intrinsics.areEqual(r30, "long_press_reply") == false) goto L53;
        String r15 = "long_press_answer";
    L54:
        String r16 = r15;
        boolean r17 = com.larus.bmhome.chat.bean.d.f0(r27);     // Catch: Throwable -> L61
        String r22 = b(r3);     // Catch: Throwable -> L61
        if (com.larus.bmhome.chat.bean.d.G0(r27) == false) goto L57;
        String r18 = "user";
    L58:
        tx9.c0.g(null, null, r12, r13, null, "chat", null, Integer.valueOf(r14 ? 1 : 0), r16, r18, null, null, r19, Boolean.valueOf(r17), null, r22, null, 340307);     // Catch: Throwable -> L61
        goto L59
    L57:
        r18 = "bot";
        goto L58
    L53:
        r15 = "creation_overview_click";
        goto L54
    L45:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L61
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
    L59:
        Object r21 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L61
    L63:
        Throwable r23 = Result.exceptionOrNull-impl(r21);
        if (r23 == null) goto L66;
        FLogger.a.e("CreationAttachmentCiteHelper", "citeSingleAttachmentToInput failed", r23);
    L66:
        Boolean r24 = Boolean.FALSE;
        if (Result.isFailure-impl(r21) == false) goto L70;
        r21 = r24;
    L70:
        return ((Boolean) r21).booleanValue();
    L30:
        r3 = null;
    L9:
        if (r26 == null) goto L12;
        FragmentActivity r33 = r26.getActivity();     // Catch: Throwable -> L61
        if (r33 == null) goto L12;
    L16:
        if (r33 == null) goto L20;
        t1a.b r34 = s1a.a.h(r33);     // Catch: Throwable -> L61
        if (r34 == null) goto L20;
        r6 = (g1) r34.getAbility(g1.class);     // Catch: Throwable -> L61
    L20:
        r6 = null;
    L12:
        FragmentActivity r35 = r25.getContext();     // Catch: Throwable -> L61
        if ((r35 instanceof FragmentActivity) == false) goto L15;
        r33 = r35;     // Catch: Throwable -> L61
        goto L16
    L15:
        r33 = null;
    L61:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    }
}
