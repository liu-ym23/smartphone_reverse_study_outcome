package b7b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.VisitInfo;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.o;
import com.ss.android.lark.widget.light.span.q;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.h;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import w4b.d0;
import x9b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final d0 a = null;

    public class a implements IMRichTextCopyUtils.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;

        @Override // com.ss.android.lark.chat.utils.IMRichTextCopyUtils.a
        public final void onSuccess() {
            if (this.a == false) goto L6;
            UDToast.show(this.b, 2131891640);
            return;
        }

        @Override // com.ss.android.lark.chat.utils.IMRichTextCopyUtils.a
        public final void onError(Exception r4) {
            if ((r4 instanceof SensitiveAPIException) == false) goto L5;
            UDToast.show(this.b, 2131891032);
            boolean r0 = false;
        L6:
            Log.e("ChatMessageUtils", "Copy failed", r4, r0);
            return;
        L5:
            r0 = true;
            goto L6
        }

        public a(boolean r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = ChatCoreModule.a().getSettingDependency();
    }

    public static CharSequence e(CharSequence r7) {
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if ((r7 instanceof Spanned) == true) goto L8;
        return r7;
    L8:
        Spanned r8 = (Spanned) r7;
        h[] r0 = (h[]) r8.getSpans(0, r8.length(), h.class);
        if (r0 != null) goto L11;
    L17:
        e[] r1 = (e[]) r8.getSpans(0, r8.length(), e.class);
        if (r1 != null) goto L20;
        return r8;
    L20:
        if (r1.length <= 0) goto L30;
        SpannableStringBuilder r2 = new SpannableStringBuilder(r8);
        int r9 = r1.length;
    L22:
        r9 = r9 - 1;
        if (r9 < 0) goto L26;
        r2.replace(r2.getSpanStart(r1[r9]), r2.getSpanEnd(r1[r9]), BuildConfig.FLAVOR);
        goto L22
    L26:
        return r2;
    L30:
        return r8;
    L11:
        if (r0.length <= 0) goto L17;
        SpannableStringBuilder r3 = new SpannableStringBuilder(r8);
        int r10 = r0.length;
    L13:
        r10 = r10 - 1;
        if (r10 < 0) goto L16;
        r3.replace(r3.getSpanStart(r0[r10]), r3.getSpanEnd(r0[r10]), r0[r10].a);
        goto L13
    L16:
        r8 = r3;
        goto L17
    }

    public static void f(Message r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (ImSdkMessageUtils.c(r7) == false) goto L10;
        long r0 = a.a();
        if ((r0 - r7.getBurnTime()) >= 7200000) goto L11;
        Log.i(String.format("%s id:%s, create:%s, life:%s, burn:%s, ntp:%s", new Object[]{"burn message ", r7.getId(), Long.valueOf(r7.getCreateTime()), Integer.valueOf(r7.getBurnLife()), Long.valueOf(r7.getBurnTime()), Long.valueOf(r0)}));
        return;
    L11:
        return;
    }

    public static int[][] c(q[] r6, Spanned r7) {
        int[][] r0 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r6.length, 2});
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L6;
        r0[r2][0] = r7.getSpanStart(r6[r2]);
        r0[r2][1] = r7.getSpanEnd(r6[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static CharSequence d(CharSequence r11, Map<String, Doc> r12, Map<String, PreviewHangPoint> r13) {
        if (CollectionUtils.isEmpty(r13) == false) goto L6;
    L14:
        boolean r0 = false;
    L16:
        if (r0 == true) goto L53;
        if (TextUtils.isEmpty(r11) == false) goto L21;
        return BuildConfig.FLAVOR;
    L21:
        if ((r11 instanceof Spanned) == true) goto L23;
        return r11;
    L23:
        if (CollectionUtils.isEmpty(r12) == true) goto L116;
        Spanned r14 = (Spanned) r11;
        q[] r1 = (q[]) r14.getSpans(0, r14.length(), q.class);
        if (r1 != null) goto L28;
    L29:
        r1 = new q[0];
    L30:
        int[][] r15 = c(r1, r14);
        HashMap r5 = new HashMap();
        Iterator<Doc> r16 = r12.values().iterator();
    L32:
        if (r16.hasNext() == false) goto L37;
        Doc r6 = r16.next();
        if (r6 == null) goto L32;
        r5.put(r6.getUrl(), r6.getName());
        goto L32
    L37:
        if (r15.length > 0) goto L39;
        return r11;
    L39:
        if (r5.size() <= 0) goto L115;
        SpannableStringBuilder r17 = new SpannableStringBuilder(r11);
        int r18 = r15.length - 1;
    L41:
        if (r18 < 0) goto L51;
        int[] r7 = r15[r18];
        int r8 = r7[0];
        int r9 = r7[1];
        String r10 = r1[r18].a.href;
        String r19 = (String) r5.get(r10);
        if (r17.charAt(r8) != '$') goto L49;
        if (r19 != null) goto L46;
    L48:
        r17.replace(r8, r8 + 1, BuildConfig.FLAVOR);
        goto L49
    L46:
        if ((r19.length() + 1) > (r9 - r8)) goto L48;
        r17.replace(r8, r9, r10);
    L49:
        r18 = r18 - 1;
        goto L41
    L51:
        return r17;
    L115:
        return r11;
    L28:
        if (r1.length != 0) goto L30;
    L116:
        return r11;
    L53:
        if (TextUtils.isEmpty(r11) == false) goto L56;
        return BuildConfig.FLAVOR;
    L56:
        if ((r11 instanceof Spanned) == true) goto L58;
        return r11;
    L58:
        if (CollectionUtils.isEmpty(r13) == true) goto L121;
        Spanned r110 = (Spanned) r11;
        q[] r2 = (q[]) r110.getSpans(0, r110.length(), q.class);
        if (r2 != null) goto L63;
    L64:
        r2 = new q[0];
    L65:
        int[][] r111 = c(r2, r110);
        HashMap r20 = new HashMap();
        Iterator<PreviewHangPoint> r112 = r13.values().iterator();
    L67:
        if (r112.hasNext() == false) goto L74;
        PreviewHangPoint r21 = r112.next();
        if (r21 == null) goto L67;
        if (r21.getUrlCardPreviewEntity() == null) goto L67;
        r20.put(r21.getUrl(), r21.getUrlCardPreviewEntity().getInlineEntity().getTitle());
        goto L67
    L74:
        if (r111.length > 0) goto L76;
        return r11;
    L76:
        if (r20.size() <= 0) goto L120;
        SpannableStringBuilder r113 = new SpannableStringBuilder(r11);
        int r114 = r111.length - 1;
    L78:
        if (r114 < 0) goto L88;
        int[] r22 = r111[r114];
        int r23 = r22[0];
        int r24 = r22[1];
        String r25 = r2[r114].a.href;
        String r26 = (String) r20.get(r25);
        if (r113.charAt(r23) != '$') goto L86;
        if (r26 != null) goto L83;
    L85:
        r113.replace(r23, r23 + 1, BuildConfig.FLAVOR);
        goto L86
    L83:
        if ((r26.length() + 1) > (r24 - r23)) goto L85;
        r113.replace(r23, r24, r25);
    L86:
        r114 = r114 - 1;
        goto L78
    L88:
        return r113;
    L120:
        return r11;
    L63:
        if (r2.length != 0) goto L65;
    L121:
        return r11;
    L6:
        if (CollectionUtils.isEmpty(r12) == true) goto L13;
        Iterator<String> r3 = r12.keySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        if (r13.containsKey(r3.next()) == false) goto L10;
    L13:
        r0 = true;
        goto L16
    }

    public static void a(Context r2, CharSequence r3, Token r4, IMRichTextCopyUtils.a r5) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r5.onError(new IllegalArgumentException("copyText is empty"));
        return;
    L6:
        ClipboardManager r6 = (ClipboardManager) r2.getSystemService("clipboard");
        qf7.a.a.a(r6, ClipData.newPlainText(BuildConfig.FLAVOR, o.c(r3)), r4);     // Catch: Exception -> L9
        r5.onSuccess();     // Catch: Exception -> L9
    L11:
        MessageHitPoint.a.a().sendEvent("message_copy", new JSONObject().put("message_type", "text"));
        return;
    L9:
        e = move-exception;
        Log.e("ChatMessageUtils", "Copy failed", e);
        r5.onError(e);
        goto L11
    }

    public static void b(Context r6, CharSequence r7, RichText r8, String r9, Token r10, boolean r11) {
        a r5 = new a(r11, r6);
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return;
    L6:
        if (DevEnvUtil.isDebugMode(r6) == false) goto L8;
    L10:
        IMRichTextCopyUtils.m(r6, r7, r8, new VisitInfo.Builder().scene_type(VisitInfo.DownloadScene.CHAT).entity_id(r9).build(), r10, r5);
        MessageHitPoint.a.a().sendEvent("message_copy", new JSONObject().put("message_type", "text"));
        return;
    L8:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messenger.chat.editor.copy_protocol") == true) goto L10;
        a(r6, r7, r10, r5);
    }
}
