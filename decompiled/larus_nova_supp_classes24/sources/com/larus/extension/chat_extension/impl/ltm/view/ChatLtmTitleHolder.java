package com.larus.extension.chat_extension.impl.ltm.view;

import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.URLSpan;
import android.widget.CompoundButton;
import com.ixigua.lib.track.TrackParams;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.common.apphost.AppHost;
import com.larus.extension.chat_extension.impl.databinding.LarusItemLtmTitleBinding;
import com.larus.extension.chat_extension.impl.ltm.r;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotUpdateType;
import com.larus.im.d;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.utils.logger.FLogger;
import j99.h;
import j99.i;
import j99.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import uc9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmTitleHolder;", "Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmBaseHolder;", "binding", "Lcom/larus/extension/chat_extension/impl/databinding/LarusItemLtmTitleBinding;", "callback", "Lcom/larus/extension/chat_extension/impl/ltm/view/ILtmBaseAbility;", "<init>", "(Lcom/larus/extension/chat_extension/impl/databinding/LarusItemLtmTitleBinding;Lcom/larus/extension/chat_extension/impl/ltm/view/ILtmBaseAbility;)V", "getBinding", "()Lcom/larus/extension/chat_extension/impl/databinding/LarusItemLtmTitleBinding;", "lastClickTime", "", "CLICK_INTERVAL", "checkChangeListener", "com/larus/extension/chat_extension/impl/ltm/view/ChatLtmTitleHolder$checkChangeListener$1", "Lcom/larus/extension/chat_extension/impl/ltm/view/ChatLtmTitleHolder$checkChangeListener$1;", "setLtmSwitch", "", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "bindData", "data", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatLtmTitleHolder extends ChatLtmBaseHolder {
    public final LarusItemLtmTitleBinding a;
    public final j b;
    public long c;
    public final long d;
    public final a e;

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ChatLtmTitleHolder a;

        public a(ChatLtmTitleHolder r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r38, boolean r39) {
            long r2 = SystemClock.elapsedRealtime();
            ChatLtmTitleHolder r0 = this.a;
            if ((r2 - r0.c) >= r0.d) goto L6;
            r0.a.b.getToggleView().setOnCheckedChangeListener(null);
            this.a.a.b.getToggleView().setChecked(!r39);
            this.a.a.b.getToggleView().setOnCheckedChangeListener(this);
            return;
        L6:
            r0.c = r2;
            BotModel r1 = r0.b.B0();
            if (r1 == null) goto L9;
            String r3 = r1.getBotId();
        L10:
            String r4 = this.a.b.getConversationID();
            String r5 = this.a.b.getCurrentPage();
            String r6 = this.a.b.b();
            if (r39 == false) goto L13;
            String r7 = "on";
        L14:
            JSONObject r8 = new JSONObject();
            Intrinsics.checkNotNullParameter(r8, "params");
            if (r3 != null) goto L36;
        L19:
            if (r4 == null) goto L21;
            r8.put("conversation_id", r4);     // Catch: JSONException -> L17
        L21:
            if (r5 == null) goto L23;
            r8.put("current_page", r5);     // Catch: JSONException -> L17
        L23:
            if (r6 == null) goto L25;
            r8.put("previous_page", r6);     // Catch: JSONException -> L17
        L25:
            r8.put("to_status", r7);     // Catch: JSONException -> L17
        L28:
            TrackParams r9 = new TrackParams().merge(r8);
            by7.a r10 = new by7.a("click_memory_switch");
            r10.a.merge(r9);
            r10.b();
            BotServiceImpl r11 = d.a();
            BotModel r12 = this.a.b.B0();
            if (r12 == null) goto L31;
            String r13 = r12.getBotId();
        L32:
            if (r13 != null) goto L34;
            r13 = "";
        L34:
            r11.updateBot(new s(BotUpdateType.MODIFY_LTM_STATUS, r13, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(r39), null, null, null, 62914556), null);
            return;
        L31:
            r13 = null;
        L17:
            e = move-exception;
            FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickMemorySwitch " + e.getLocalizedMessage());
            goto L28
        L36:
            r8.put("bot_id", r3);     // Catch: JSONException -> L17
            goto L19
        L13:
            r7 = "off";
            goto L14
        L9:
            r3 = null;
            goto L10
        }
    }

    @Override // com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder
    public final void T3(r r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        BotModel r16 = this.b.B0();
        if (r16 == null) goto L10;
        LarusItemLtmTitleBinding r0 = this.a;
        r0.b.getToggleView().setOnCheckedChangeListener(null);
        CustomSwitchCompat r1 = r0.b.getToggleView();
        BotMemoryConfig r17 = r16.getBotMemoryConfig();
        if (r17 == null) goto L7;
        boolean r19 = Intrinsics.areEqual(r17.getSwitchStatus(), Boolean.TRUE);
    L8:
        r1.setChecked(r19);
        r0.b.getToggleView().setOnCheckedChangeListener(this.e);
        Context r110 = r0.c.getContext();
        int r2 = h.a;
        String r3 = r110.getString(2131907379);
        AppHost.Companion r111 = AppHost.a;
        String r112 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r3, "%s", r111.getAppStringName(), false, 4, null), "%1$s", r111.getAppStringName(), false, 4, null), "%2$s", r111.getAppStringName(), false, 4, null);
        String r4 = r0.c.getContext().getString(2131908117);
        SpannableString r5 = new SpannableString(r112 + r4);
        r5.setSpan(new URLSpan("https://www.doubao.com/legal/memory_faq"), r112.length(), r112.length() + r4.length(), 33);
        r0.c.setUrlText(new SpannedString(r5));
        r0.c.setOnClickListener(new i(r0));
        return;
    L7:
        r19 = false;
        goto L8
    }

    public ChatLtmTitleHolder(LarusItemLtmTitleBinding r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.d = 500;
        this.e = new a(this);
    }
}
