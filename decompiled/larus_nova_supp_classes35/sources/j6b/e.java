package j6b;

import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.UrlPreviewAction;
import com.ss.android.lark.chat.entity.preview.GetAction;
import com.ss.android.lark.chat.entity.preview.LarkCommandAction;
import com.ss.android.lark.chat.entity.preview.OpenUrlAction;
import com.ss.android.lark.chat.entity.preview.PostAction;
import com.ss.android.lark.chat.entity.preview.ShowDialogAction;
import com.ss.android.lark.chat.entity.preview.ShowToastAction;
import com.ss.android.lark.chat.entity.preview.SwitchStateAction;
import com.ss.android.lark.export.entity.preview.BaseAction;
import com.ss.android.lark.export.entity.preview.Parameters;
import com.ss.android.lark.export.entity.preview.Url;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UrlPreviewAction.Method.values().length];
            r0[UrlPreviewAction.Method.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[UrlPreviewAction.Method.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[UrlPreviewAction.Method.OPEN_URL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[UrlPreviewAction.Method.LARK_COMMAND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[UrlPreviewAction.Method.SWITCH_STATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[UrlPreviewAction.Method.SHOW_TOAST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[UrlPreviewAction.Method.SHOW_DIALOG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final Parameters a(UrlPreviewAction.Parameters r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        return new Parameters(r4.parameters, r4.user_id, r4.source_id, r4.preview_id);
    }

    @JvmStatic
    public static final ShowDialogAction b(UrlPreviewAction.ShowDialogAction r8) {
        ShowDialogAction.DialogItem r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator r2 = r8.buttons.iterator();
    L7:
        if (r2.hasNext() == false) goto L24;
        UrlPreviewAction.ShowDialogAction.DialogButton r3 = (UrlPreviewAction.ShowDialogAction.DialogButton) r2.next();
        if (r3 != null) goto L11;
        ShowDialogAction.a r4 = null;
    L22:
        if (r4 == null) goto L7;
        r1.add(r4);
        goto L7
    L11:
        String r5 = r3.text;
        ShowDialogAction.DialogButtonType.a r6 = ShowDialogAction.DialogButtonType.Companion;
        int r7 = r3.type.getValue();
        r6.getClass();
        if (r7 != 0) goto L14;
        ShowDialogAction.DialogButtonType r9 = ShowDialogAction.DialogButtonType.DEFAULT;
    L21:
        r4 = new ShowDialogAction.a(r5, r9, r3.action_id);
        goto L22
    L14:
        if (r7 != 1) goto L16;
        r9 = ShowDialogAction.DialogButtonType.PRIMARY;
        goto L21
    L16:
        if (r7 == 2) goto L18;
        r9 = ShowDialogAction.DialogButtonType.DEFAULT;
        goto L21
    L18:
        r9 = ShowDialogAction.DialogButtonType.DANGER;
        goto L21
    L24:
        UrlPreviewAction.ShowDialogAction.DialogItem r10 = r8.title;
        if (r10 != null) goto L27;
        ShowDialogAction.DialogItem r11 = null;
    L28:
        UrlPreviewAction.ShowDialogAction.DialogItem r12 = r8.content;
        if (r12 == null) goto L33;
        r0 = new ShowDialogAction.DialogItem(r12.text, r12.number_of_lines);
    L33:
        return new ShowDialogAction(r11, r0, r1);
    L27:
        r11 = new ShowDialogAction.DialogItem(r10.text, r10.number_of_lines);
        goto L28
    }

    @JvmStatic
    public static final Url c(URL r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        return new Url(r7.url, r7.ios, r7.android, r7.pc, r7.web);
    }

    @JvmStatic
    public static final com.ss.android.lark.export.entity.preview.UrlPreviewAction d(UrlPreviewAction r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "pbAction");
        int r4 = -1;
        BaseAction r5 = null;
        if (r15 == false) goto L48;
        UrlPreviewAction.Method r16 = r14.method;
        if (r16 == null) goto L8;
        r4 = a.a[r16.ordinal()];
    L8:
        switch(r4) {
            case 1: goto L42;
            case 2: goto L38;
            case 3: goto L34;
            case 4: goto L30;
            case 5: goto L26;
            case 6: goto L12;
            case 7: goto L10;
            default: goto L11;
        };
    L10:
        r5 = b(r14.show_dialog);
        goto L11
    L12:
        UrlPreviewAction.ShowToastAction r17 = r14.show_toast;
        if (r17 == null) goto L11;
        ShowToastAction.ToastType.a r6 = ShowToastAction.ToastType.Companion;
        int r7 = r17.type.getValue();
        r6.getClass();
        if (r7 == 1) goto L24;
        if (r7 == 2) goto L23;
        if (r7 == 3) goto L22;
        if (r7 == 4) goto L21;
        ShowToastAction.ToastType r0 = ShowToastAction.ToastType.SUCCESS;
    L25:
        r5 = new ShowToastAction(r0, r17.content, r17.duration.intValue());
        goto L11
    L21:
        r0 = ShowToastAction.ToastType.WARNING;
        goto L25
    L22:
        r0 = ShowToastAction.ToastType.INFO;
        goto L25
    L23:
        r0 = ShowToastAction.ToastType.ERROR;
        goto L25
    L24:
        r0 = ShowToastAction.ToastType.SUCCESS;
        goto L25
    L26:
        UrlPreviewAction.SwitchStateAction r18 = r14.switch_state;
        if (r18 == null) goto L11;
        r5 = new SwitchStateAction(r18.next_state_id);
        goto L11
    L30:
        UrlPreviewAction.LarkCommandAction r19 = r14.command;
        if (r19 == null) goto L11;
        r5 = new LarkCommandAction(r19.cmd.intValue(), a(r19.parameters));
        goto L11
    L34:
        UrlPreviewAction.OpenURLAction r110 = r14.open_url_v2;
        if (r110 == null) goto L11;
        r5 = new OpenUrlAction(c(r110.open_url));
        goto L11
    L38:
        UrlPreviewAction.PostAction r111 = r14.post;
        if (r111 == null) goto L11;
        r5 = new PostAction(a(r111.parameters));
        goto L11
    L42:
        UrlPreviewAction.GetAction r112 = r14.get;
        if (r112 == null) goto L11;
        r5 = new GetAction(a(r112.parameters));
    L11:
        BaseAction r13 = r5;
        String r8 = r14.url;
        com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a r1 = com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.Companion;
        int r2 = r14.method.getValue();
        r1.getClass();
        return new com.ss.android.lark.export.entity.preview.UrlPreviewAction(r8, com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a.a(r2), a(r14.parameters), r14.cmd.intValue(), c(r14.open_url), r14.fallback_action_id, r13);
    L48:
        UrlPreviewAction.Method r113 = r14.method;
        if (r113 == null) goto L52;
        r4 = a.a[r113.ordinal()];
    L52:
        if (r4 == 1) goto L63;
        if (r4 == 2) goto L62;
        if (r4 == 3) goto L61;
        if (r4 != 4) goto L57;
        r5 = new LarkCommandAction(r14.cmd.intValue(), a(r14.parameters));
    L64:
        String r9 = r14.url;
        com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a r3 = com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.Companion;
        int r10 = r14.method.getValue();
        r3.getClass();
        com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method r11 = com.ss.android.lark.export.entity.preview.UrlPreviewAction.Method.a.a(r10);
        Parameters r12 = a(r14.parameters);
        int r114 = r14.cmd.intValue();
        Url r115 = c(r14.open_url);
        String r116 = r14.fallback_action_id;
        return new com.ss.android.lark.export.entity.preview.UrlPreviewAction(r9, r11, r12, r114, r115, r116, r5);
    L57:
        if (r4 != 7) goto L64;
        r5 = b(r14.show_dialog);
        goto L64
    L61:
        r5 = new OpenUrlAction(c(r14.open_url));
        goto L64
    L62:
        r5 = new PostAction(a(r14.parameters));
        goto L64
    L63:
        r5 = new GetAction(a(r14.parameters));
        goto L64
    }

    @JvmStatic
    public static final LinkedHashMap<String, com.ss.android.lark.export.entity.preview.UrlPreviewAction> e(Map<String, UrlPreviewAction> r3, boolean r4) {
        LinkedHashMap<String, com.ss.android.lark.export.entity.preview.UrlPreviewAction> r0 = new LinkedHashMap();
        if (r3 == null) goto L8;
        Iterator<Map.Entry<String, UrlPreviewAction>> r5 = r3.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<String, UrlPreviewAction> r1 = r5.next();
        r0.put(r1.getKey(), d(r1.getValue(), r4));
    L8:
        return r0;
    }
}
