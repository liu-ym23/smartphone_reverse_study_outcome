package oca;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.camera.CameraSize;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemMsgSendBinding;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j0 extends b {
    public final Lazy x;

    public static final class a {
    }

    static {
    }

    private final ObricCardItemMsgSendBinding getBinding() {
        return (ObricCardItemMsgSendBinding) this.x.getValue();
    }

    public j0(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.x = LazyKt.lazy(new i0(r2, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(String r6) {
    L11:
        e = move-exception;
        FLogger.a.e("MsgSendBox", "openApp: error opening " + r6, e);
        return;
    L4:
        if (Intrinsics.areEqual(r6, "com.android.mms") == false) goto L6;
        Intent r3 = new Intent("android.intent.action.MAIN");     // Catch: Exception -> L11
        r3.setClassName("com.android.mms", "com.android.mms.ui.ConversationList");     // Catch: Exception -> L11
        r3.addFlags(67108864);     // Catch: Exception -> L11
    L7:
        if (r3 == null) goto L9;
        r3.addFlags(268435456);     // Catch: Exception -> L11
        getContext().startActivity(r3);     // Catch: Exception -> L11
        return;
    L9:
        FLogger.a.w("MsgSendBox", "openApp: launch intent null for " + r6);     // Catch: Exception -> L11
        return;
    L6:
        r3 = getContext().getPackageManager().getLaunchIntentForPackage(r6);     // Catch: Exception -> L11
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BitmapDrawable u(Drawable r8) {
        if ((r8 instanceof BitmapDrawable) == false) goto L7;
        BitmapDrawable r0 = (BitmapDrawable) r8;
        if (r0.getBitmap() == null) goto L7;
        return r0;
    L7:
        Integer r1 = Integer.valueOf(r8.getIntrinsicWidth());
        boolean r2 = true;
        if (r1.intValue() <= 0) goto L10;
        boolean r3 = true;
    L11:
        Integer r4 = null;
        if (r3 == true) goto L15;
        r1 = null;
    L15:
        int r5 = CameraSize.lowWidth;
        if (r1 == null) goto L18;
        int r6 = r1.intValue();
    L19:
        Integer r7 = Integer.valueOf(r8.getIntrinsicHeight());
        if (r7.intValue() > 0) goto L23;
        r2 = false;
    L23:
        if (r2 == false) goto L25;
        r4 = r7;
    L25:
        if (r4 == null) goto L27;
        r5 = r4.intValue();
    L27:
        Rect r9 = new Rect(r8.getBounds());
        Bitmap r10 = Bitmap.createBitmap(r6, r5, Bitmap.Config.ARGB_8888);
        r8.setBounds(0, 0, r6, r5);
        r8.draw(new Canvas(r10));
        r8.setBounds(r9);
        return new BitmapDrawable(getResources(), r10);
    L18:
        r6 = CameraSize.lowWidth;
        goto L19
    L10:
        r3 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oca.b
    public final void o(AppIntentMessage r23, Message r24) {
        Intrinsics.checkNotNullParameter(r23, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r24, "message");
        Map r1 = r23.getExt();
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        final String r4 = (String) r1.get("package_name");
        if (r4 != null) goto L8;
    L15:
        String r5 = r23.getDataSource().getIntentName();
        if (Intrinsics.areEqual(r5, "Office_SendMessage") == false) goto L19;
        r4 = "com.ss.android.lark";
    L22:
        List<Parcelable> r2 = com.obric.assistant.card.utils.c.d(r23);
        if (r2 != null) goto L25;
        r2 = CollectionsKt.emptyList();
    L25:
        ArrayList r10 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L27:
        if (r3.hasNext() == false) goto L39;
        Object r11 = (Parcelable) r3.next();
        if ((r11 instanceof AppIntentCardData) == false) goto L31;
        AppIntentCardData r12 = (AppIntentCardData) r11;
    L32:
        if (r12 == null) goto L37;
        Object r13 = com.obric.assistant.card.utils.c.c(r12);
        if (r13 == null) goto L37;
        r11 = r13;
    L37:
        if (r11 == null) goto L27;
        r10.add(r11);
        goto L27
    L31:
        r12 = null;
        goto L32
    L39:
        Iterator r6 = r10.iterator();
    L41:
        if (r6.hasNext() == false) goto L45;
        Object r14 = r6.next();
        if ((r14 instanceof MessageEntity) == false) goto L41;
    L47:
        if ((r14 instanceof MessageEntity) == false) goto L49;
        final MessageEntity r15 = (MessageEntity) r14;
    L50:
        getBinding().a.setAlpha(1.0f);
        n(getBinding().a, v19.c.a(2130970533, getContext(), 2131102542));
        if (r4 != null) goto L53;
    L56:
        boolean r16 = true;
    L58:
        if (r16 == false) goto L60;
        getBinding().b.setVisibility(8);
        getBinding().c.setVisibility(8);
    L80:
        boolean r7 = Intrinsics.areEqual(r4, "com.ss.android.lark");
        final String r8 = NameKeys.UnloadStrategy_No_Strategy;
        if (r7 == false) goto L122;
        if (r15 == null) goto L84;
        GroupChatEntity r9 = r15.getGroupChat();
    L85:
        if (r15 == null) goto L89;
        List r17 = r15.getContacts();
        if (r17 == null) goto L89;
        ContactEntity r18 = (ContactEntity) CollectionsKt.getOrNull(r17, 0);
    L90:
        if (r9 == null) goto L95;
        FileEntity r19 = r9.getAvatar();
        if (r19 == null) goto L95;
        Uri r20 = r19.getContentUrl();
        if (r20 == null) goto L95;
    L100:
        if (r20 == null) goto L106;
        int r110 = PrivilegedUriProvider.b;
        if (r4 != null) goto L104;
        String r111 = NameKeys.UnloadStrategy_No_Strategy;
    L105:
        Uri r21 = PrivilegedUriProvider.a.a(r20, r111, false, false);
    L107:
        if (r9 == null) goto L110;
        String r22 = r9.getName();
        if (r22 == null) goto L110;
    L114:
        if (r21 == null) goto L116;
        getBinding().d.getHierarchy().setPlaceholderImage(2131244449);
        ImageLoaderKt.s(getBinding().d, r21, "obric_chat.cards");
    L117:
        TextView r25 = getBinding().k;
        if (r22 != null) goto L120;
        r22 = NameKeys.UnloadStrategy_No_Strategy;
    L120:
        r25.setText(r22);
    L125:
        if (r15 == null) goto L127;
        String r26 = r15.getText();
    L128:
        if (r26 != null) goto L130;
        String r112 = NameKeys.UnloadStrategy_No_Strategy;
    L131:
        getBinding().h.setText("我: " + StringsKt.replace$default(r112, "\n", NameKeys.UnloadStrategy_No_Strategy, false, 4, null));
        getBinding().l.setOnClickListener(null);
        if (r4 != null) goto L134;
    L137:
        boolean r27 = true;
    L138:
        if (r27 == false) goto L140;
    L142:
        getBinding().i.setOnClickListener(null);
        if (this.p == false) goto L146;
        e1.d(getBinding().i, new h0(r4, this, r15));
    L146:
        String r28 = r24.getBizContentType();
        if (Intrinsics.areEqual(r28, OAppIntentBizContentType.MSG_CONFIRM_CARD) == false) goto L191;
        getBinding().g.setVisibility(0);
        String r29 = (String) r1.get("msg_send_status");
        if (r29 != null) goto L151;
        r29 = "confirm";
    L151:
        String r30 = r24.getLocalMessageId();
        if (r30 == null) goto L155;
        r8 = r30;
    L155:
        FLogger r31 = FLogger.a;
        StringBuilder r32 = new StringBuilder("renderConfirmStatus enter: status=");
        r32.append(r29);
        r32.append(", isEnable=");
        r32.append(this.p);
        r32.append(", localMsgId=");
        r32.append(r8);
        r32.append(", localMsgIdEmpty=");
        if (r8.length() != 0) goto L158;
        boolean r113 = true;
    L159:
        r32.append(r113);
        r32.append(", pkg=");
        r32.append(r4);
        r31.i("MsgSendBox", r32.toString());
        int r33 = r29.hashCode();
        if (r33 == (-1281977283)) goto L187;
        if (r33 == 951117504) goto L171;
        if (r33 == 2043017103) goto L167;
    L188:
        r31.w("MsgSendBox", "renderConfirmStatus: UNEXPECTED status=" + r29 + ", btnSend shown WITHOUT click listener, localMsgId=" + r8);
        getBinding().f.setVisibility(0);
        getBinding().f.setText(getContext().getString(2131912269));
        getBinding().m.setVisibility(8);
        getBinding().f.setOnClickListener(null);
        return;
    L167:
        if (r29.equals("executed") == false) goto L188;
        r31.i("MsgSendBox", "renderConfirmStatus: STATUS_EXECUTED, localMsgId=".concat(r8));
        getBinding().f.setVisibility(8);
        getBinding().f.setOnClickListener(null);
        getBinding().m.setVisibility(0);
        getBinding().m.setText(getContext().getString(2131912270));
        return;
    L171:
        if (r29.equals("confirm") == false) goto L188;
        getBinding().f.setVisibility(0);
        getBinding().f.setText(getContext().getString(2131912269));
        getBinding().m.setVisibility(8);
        if (this.p == true) goto L176;
    L181:
        StringBuilder r34 = new StringBuilder("renderConfirmStatus: btnSend NOT clickable, isEnable=");
        r34.append(this.p);
        r34.append(", localMsgIdEmpty=");
        if (r8.length() != 0) goto L184;
        boolean r35 = true;
    L185:
        r34.append(r35);
        r31.w("MsgSendBox", r34.toString());
        getBinding().f.setOnClickListener(null);
        return;
    L184:
        r35 = false;
        goto L185
    L176:
        if (r8.length() <= 0) goto L178;
        boolean r36 = true;
    L179:
        if (r36 == false) goto L181;
        r31.i("MsgSendBox", "renderConfirmStatus: attach click listener, localMsgId=".concat(r8));
        e1.d(getBinding().f, new f0(r8));
        return;
    L178:
        r36 = false;
        goto L179
    L187:
        if (r29.equals("failed") == false) goto L188;
        r31.i("MsgSendBox", "renderConfirmStatus: STATUS_FAILED, localMsgId=".concat(r8));
        getBinding().f.setVisibility(0);
        getBinding().f.setText(getContext().getString(2131912271));
        getBinding().f.setOnClickListener(null);
        getBinding().f.setClickable(false);
        getBinding().m.setVisibility(8);
        getBinding().a.setAlpha(0.5f);
        getBinding().l.setOnClickListener(null);
        getBinding().l.setClickable(false);
        getBinding().i.setOnClickListener(null);
        getBinding().i.setClickable(false);
        return;
    L158:
        r113 = false;
        goto L159
    L191:
        if (Intrinsics.areEqual(r28, OAppIntentBizContentType.MSG_DISPLAY_CARD) == false) goto L193;
        FLogger.a.i("MsgSendBox", "bindCardData: MSG_DISPLAY_CARD (no send button), localMsgId=" + r24.getLocalMessageId());
        getBinding().g.setVisibility(8);
        getBinding().e.setVisibility(0);
        return;
    L193:
        FLogger.a.w("MsgSendBox", "bindCardData: unexpected bizContentType=" + r24.getBizContentType() + ", localMsgId=" + r24.getLocalMessageId());
        getBinding().g.setVisibility(8);
        return;
    L140:
        if (this.p == false) goto L142;
        e1.d(getBinding().l, new g0(this, r4));
        goto L142
    L134:
        if (r4.length() == 0) goto L137;
        r27 = false;
        goto L138
    L130:
        r112 = r26;
        goto L131
    L127:
        r26 = null;
        goto L128
    L116:
        getBinding().d.setImageResource(2131244449);
    L110:
        if (r18 == null) goto L112;
        r22 = r18.getName();
        goto L114
    L112:
        r22 = null;
        goto L114
    L104:
        r111 = r4;
        goto L105
    L106:
        r21 = null;
    L95:
        if (r18 == null) goto L99;
        FileEntity r37 = r18.getAvatar();
        if (r37 == null) goto L99;
        r20 = r37.getContentUrl();
    L99:
        r20 = null;
    L89:
        r18 = null;
        goto L90
    L84:
        r9 = null;
        goto L85
    L122:
        if (Intrinsics.areEqual(r4, "com.android.mms") == false) goto L124;
        t(r15, r4);
        goto L125
    L124:
        t(r15, r4);
        goto L125
    L60:
        getBinding().b.setVisibility(0);
        getBinding().c.setVisibility(0);
        PackageManager r114 = getContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L71
        ApplicationInfo r38 = r114.getApplicationInfo(r4, 0);     // Catch: PackageManager.NameNotFoundException -> L71
        Drawable r115 = r38.loadIcon(r114);     // Catch: PackageManager.NameNotFoundException -> L71
        if (r115 != null) goto L68;
        FLogger.a.e("MsgSendBox", "renderHeader: loadIcon returned null, packageName=" + r4);     // Catch: PackageManager.NameNotFoundException -> L71
        ImageView r39 = getBinding().b;     // Catch: PackageManager.NameNotFoundException -> L71
        if (Intrinsics.areEqual(r4, "com.ss.android.lark") == false) goto L66;
        int r116 = 2131244447;
    L67:
        r39.setImageResource(r116);     // Catch: PackageManager.NameNotFoundException -> L71
    L69:
        getBinding().c.setText(r114.getApplicationLabel(r38).toString());     // Catch: PackageManager.NameNotFoundException -> L71
        goto L80
    L66:
        r116 = 2131244560;
        goto L67
    L68:
        getBinding().b.setImageDrawable(u(r115));     // Catch: PackageManager.NameNotFoundException -> L71
    L71:
        FLogger.a.w("MsgSendBox", "renderHeader: package not found " + r4);
        ImageView r40 = getBinding().b;
        if (Intrinsics.areEqual(r4, "com.ss.android.lark") == false) goto L74;
        int r117 = 2131244447;
    L75:
        r40.setImageResource(r117);
        TextView r41 = getBinding().c;
        if (Intrinsics.areEqual(r4, "com.ss.android.lark") == false) goto L78;
        String r42 = getContext().getString(2131912198);
    L79:
        r41.setText(r42);
        goto L80
    L78:
        r42 = getContext().getString(2131912281);
        goto L79
    L74:
        r117 = 2131244560;
        goto L75
    L53:
        if (r4.length() == 0) goto L56;
        r16 = false;
        goto L58
    L49:
        r15 = null;
        goto L50
    L45:
        r14 = null;
        goto L47
    L19:
        if (Intrinsics.areEqual(r5, "Messages_Send") == false) goto L21;
        r4 = "com.android.mms";
        goto L22
    L21:
        r4 = null;
        goto L22
    L8:
        if (r4.length() <= 0) goto L10;
        boolean r118 = true;
    L11:
        if (r118 == true) goto L14;
        r4 = null;
    L14:
        if (r4 != null) goto L22;
    L10:
        r118 = false;
        goto L11
    }

    public final void t(MessageEntity r8, String r9) {
        boolean r0 = false;
        String r1 = null;
        if (r8 == null) goto L7;
        List r2 = r8.getContacts();
        if (r2 == null) goto L7;
        ContactEntity r3 = (ContactEntity) CollectionsKt.getOrNull(r2, 0);
    L8:
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 == null) goto L18;
        FileEntity r5 = r3.getAvatar();
        if (r5 == null) goto L18;
        Uri r6 = r5.getContentUrl();
        if (r6 == null) goto L18;
        int r7 = PrivilegedUriProvider.b;
        if (r9 != null) goto L17;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        Uri r10 = PrivilegedUriProvider.a.a(r6, r9, false, false);
    L20:
        if (r3 == null) goto L29;
        String r11 = r3.getName();
        if (r11 == null) goto L29;
        if (r11.length() <= 0) goto L26;
        boolean r12 = true;
    L27:
        if (r12 == false) goto L29;
    L30:
        if (r3 == null) goto L37;
        List r13 = r3.getTelephones();
        if (r13 == null) goto L37;
        MetaTelephone r14 = (MetaTelephone) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L37;
        String r15 = r14.getTelephone();
        if (r15 == null) goto L37;
    L43:
        if (r10 == null) goto L45;
        getBinding().d.getHierarchy().setPlaceholderImage(2131244449);
        ImageLoaderKt.s(getBinding().d, r10, "obric_chat.cards");
    L46:
        TextView r16 = getBinding().k;
        if (r11 == null) goto L49;
        r4 = r11;
    L57:
        r16.setText(r4);
        return;
    L49:
        if (r15 != null) goto L51;
    L55:
        if (r1 == null) goto L57;
        r4 = r1;
        goto L57
    L51:
        if (r15.length() <= 0) goto L53;
        r0 = true;
    L53:
        if (r0 == false) goto L55;
        r1 = r15;
        goto L55
    L45:
        getBinding().d.setImageResource(2131244449);
    L37:
        if (r8 == null) goto L41;
        List r17 = r8.getTelephones();
        if (r17 == null) goto L41;
        r15 = (String) CollectionsKt.firstOrNull(r17);
    L41:
        r15 = null;
        goto L43
    L26:
        r12 = false;
    L29:
        r11 = null;
    L18:
        r10 = null;
    L7:
        r3 = null;
        goto L8
    }
}
