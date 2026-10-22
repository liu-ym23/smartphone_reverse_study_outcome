package com.ss.android.lark.chat.name;

import android.content.Context;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.translate.LanguageInfo;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.r;
import com.ss.android.lark.translate.dialog.MoreTranslateActionDialog;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.dialog.SwitchTranslateDialog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/name/ChatNameRenderer$showTranslateOptionsDialog$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chat/entity/translate/TranslateLanguageSetting;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatNameRenderer$showTranslateOptionsDialog$1 implements IGetDataCallback<TranslateLanguageSetting> {
    final /* synthetic */ Chat $chat;
    final /* synthetic */ Context $context;
    final /* synthetic */ com.ss.android.lark.chat.name.a this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ com.ss.android.lark.chat.name.a a;
        public final /* synthetic */ Chat b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ TranslateLanguageSetting d;

        public a(com.ss.android.lark.chat.name.a r1, Chat r2, Context r3, TranslateLanguageSetting r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            com.ss.android.lark.chat.name.a r0 = this.a;
            Chat r1 = this.b;
            Context r3 = this.c;
            TranslateLanguageSetting r2 = this.d;
            com.ss.android.lark.chat.name.a.b r4 = r0.d;
            boolean r5 = false;
            if (r4 == null) goto L14;
            WeakReference<MoreTranslateActionDialog> r6 = r4.b;
            if (r6 == null) goto L14;
            MoreTranslateActionDialog r7 = r6.get();
            if (r7 == null) goto L14;
            LKUIDialog r8 = ((fcc.c) r7).b;
            if (r8 == null) goto L11;
            boolean r9 = r8.isShowing();
        L12:
            if (r9 != true) goto L14;
            boolean r10 = true;
        L15:
            String r11 = null;
            if (r10 == true) goto L18;
            r0.d = null;
        L18:
            com.ss.android.lark.chat.name.a.b r12 = r0.d;
            if (r12 == null) goto L21;
            String r13 = r12.a;
        L23:
            if (Intrinsics.areEqual(r13, r1.getId()) == false) goto L39;
            com.ss.android.lark.chat.name.a.b r14 = r0.d;
            if (r14 == null) goto L36;
            WeakReference<MoreTranslateActionDialog> r15 = r14.b;
            if (r15 == null) goto L36;
            MoreTranslateActionDialog r16 = r15.get();
            if (r16 == null) goto L36;
            LKUIDialog r17 = ((fcc.c) r16).b;
            if (r17 == null) goto L33;
            boolean r18 = r17.isShowing();
        L34:
            if (r18 != true) goto L36;
            boolean r19 = true;
        L37:
            if (r19 == false) goto L39;
            Log.w("ChatNameRenderer", "[chat_name_translate] repeat show translate options dialog inner");
            boolean r20 = true;
        L40:
            if (r20 == true) goto L110;
            if (r2 == null) goto L50;
            Map r21 = new LinkedHashMap();
            List<LanguageInfo> r22 = r2.getSupportedLanguageList();
            if (r22 == null) goto L51;
            Iterator<LanguageInfo> r23 = r22.iterator();
        L48:
            if (r23.hasNext() == false) goto L51;
            LanguageInfo r110 = r23.next();
            r21.put(r110.getKey(), r110.getCurLanguageDisplayName());
        L51:
            if (r2 == null) goto L53;
            r11 = r2.getTargetLanguageKey();
        L53:
            boolean r24 = !r21.isEmpty();
            if (r.a(r1.getNameMajorLanguage()) == true) goto L56;
        L58:
            boolean r25 = false;
        L59:
            ArrayList r111 = new ArrayList();
            if (r1.shouldDisplayTranslatedName() == true) goto L62;
        L69:
            if (r25 == false) goto L71;
            r111.add(new MoreTranslateActionDialog.a(2131256160, UIUtils.getString(r3, 2131891400), MoreTranslateActionDialog.MoreActionType.Translate));
        L71:
            if (r24 == false) goto L74;
            r111.add(new MoreTranslateActionDialog.a(2131256042, UIUtils.getString(r3, 2131891399), MoreTranslateActionDialog.MoreActionType.SwitchLanguage));
        L74:
            if (r111.isEmpty() == false) goto L76;
            Log.e("ChatNameRenderer", "[chat_name_translate] no option items. do not show dialog.");
            return;
        L76:
            MoreTranslateActionDialog r26 = new MoreTranslateActionDialog(r3, UIHelper.getString(2131890229), r111, new b(r0, r1, r3, r11));
            r26.j();
            r0.d = new com.ss.android.lark.chat.name.a.b(r1.getId(), r26);
            if ((!r21.isEmpty()) == false) goto L109;
            ArrayList r27 = new ArrayList();
            HashMap r28 = new HashMap();
            Iterator r29 = r21.entrySet().iterator();
        L80:
            if (r29.hasNext() == false) goto L88;
            Map.Entry r30 = (Map.Entry) r29.next();
            String r31 = (String) r30.getKey();
            String r32 = (String) r30.getValue();
            if (Intrinsics.areEqual(r31, r1.getNameTranslateLanguage()) == true) goto L80;
            if (Intrinsics.areEqual(r31, r1.getNameMajorLanguage()) == true) goto L80;
            r27.add(r32);
            r28.put(Integer.valueOf(r27.size() - 1), r31);
            goto L80
        L88:
            SwitchTranslateDialog.DialogHeightType r33 = SwitchTranslateDialog.DialogHeightType.MatchScreen;
            if (r27.size() > 7) goto L91;
            r33 = SwitchTranslateDialog.DialogHeightType.WrapContent;
        L91:
            SwitchTranslateDialog r34 = new SwitchTranslateDialog(r3, UIHelper.getString(2131890232), r27, new c(r28, r0, r1, r3), r33);
            List r35 = r26.p.a;
            if (r35 == null) goto L97;
            Iterator r36 = r35.iterator();
        L95:
            if (r36.hasNext() == false) goto L97;
            ((MoreTranslateActionDialog.b) r36.next()).i = r34;
        L97:
            r34.u = r26;
            return;
        L109:
            return;
        L62:
            if (r1.getTranslatedName().length() <= 0) goto L64;
            r5 = true;
        L64:
            if (r5 == false) goto L69;
            r111.add(new MoreTranslateActionDialog.a(2131256159, UIUtils.getString(r3, 2131891398), MoreTranslateActionDialog.MoreActionType.HideTranslate));
            if (r24 == false) goto L68;
            r111.add(new MoreTranslateActionDialog.a(2131256042, UIUtils.getString(r3, 2131891399), MoreTranslateActionDialog.MoreActionType.SwitchLanguage));
        L68:
            r111.add(new MoreTranslateActionDialog.a(2131256040, UIUtils.getString(r3, 2131891396), MoreTranslateActionDialog.MoreActionType.Feedback));
            goto L74
        L56:
            if (Intrinsics.areEqual(r11, r1.getNameMajorLanguage()) == true) goto L58;
            r25 = true;
            goto L59
        L50:
            r21 = MapsKt.emptyMap();
            goto L51
        L110:
            return;
        L33:
            r18 = false;
        L36:
            r19 = false;
        L39:
            r20 = false;
            goto L40
        L21:
            r13 = null;
            goto L23
        L11:
            r9 = false;
        L14:
            r10 = false;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        Log.e("ChatNameRenderer", "get translate settings fail.");
    }

    public void onSuccess(TranslateLanguageSetting r5) {
        UICallbackExecutor.post(new a(this.this$0, this.$chat, this.$context, r5));
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((TranslateLanguageSetting) r1);
    }

    public ChatNameRenderer$showTranslateOptionsDialog$1(com.ss.android.lark.chat.name.a r1, Chat r2, Context r3) {
        this.this$0 = r1;
        this.$chat = r2;
        this.$context = r3;
    }
}
