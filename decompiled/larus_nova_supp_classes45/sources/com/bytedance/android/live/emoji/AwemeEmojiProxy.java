package com.bytedance.android.live.emoji;

import android.graphics.drawable.Drawable;
import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.live.emoji.online.OnlineEmojiApi;
import com.bytedance.android.live.emoji.online.OnlineSmallEmojiResManager;
import com.bytedance.android.live.emoji.online.h;
import com.bytedance.android.live.emoji.online.i;
import com.bytedance.android.live.emoji.utils.EmojiResHelper;
import com.bytedance.android.live.emoji.utils.a;
import com.bytedance.android.live.emoji.utils.d;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r90.e;
import r90.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/emoji/AwemeEmojiProxy;", "Lcom/bytedance/android/live/emoji/api/IAwemeEmojiProxy;", "()V", "getRealDrawable", "Landroid/graphics/drawable/Drawable;", "emojiText", "", "getRecommendEmojiList", "", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "loadAllBaseEmoji", "preloadOnlineEmoji", "", "updateRecentEmoji", "liveemoji-impl_release"}, k = 1, mv = {1, 4, 3})
public class AwemeEmojiProxy implements IAwemeEmojiProxy {
    public AwemeEmojiProxy() {
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public List<BaseEmoji> getRecommendEmojiList() {
        List<String> r0 = f.a;
        IUserService r1 = k.f(IUserService.class);
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.user.f r2 = r1.user();
        if (r2 == null) goto L8;
        String r3 = r2.n();
        if (r3 == null) goto L8;
    L10:
        if ((!Intrinsics.areEqual(f.b, r3)) == false) goto L21;
        f.b = r3;
        String r4 = a.a().a.getString("recent_system_small_emojis", "");
        Gson r5 = d.a;     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(String[].class, "clazz");     // Catch: Exception -> L18
        Object[] r6 = (Object[]) GsonProtectorUtils.fromJson(d.a, r4, String[].class);     // Catch: Exception -> L18
        if (r6 == null) goto L16;
        List<String> r7 = ArraysKt.toMutableList(r6);     // Catch: Exception -> L18
        if (r7 == null) goto L16;
    L20:
        f.a = r7;
    L16:
        r7 = new ArrayList();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        ArrayList r8 = new ArrayList();
        ALogger.e("BusinessEmojiSPUtils", e);
        r7 = r8;
    L21:
        List<String> r9 = f.a;
        if (r9 != null) goto L24;
        r9 = CollectionsKt.emptyList();
    L24:
        EmojiResHelper r11 = EmojiResHelper.c;
        List<BaseEmoji> r12 = EmojiResHelper.a.a(jc1.a.b()).b(r9);
        if (r12.size() > 8) goto L27;
        return r12;
    L27:
        return r12.subList(0, 8);
    L8:
        r3 = "0";
        goto L10
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public List<BaseEmoji> loadAllBaseEmoji() {
        EmojiResHelper r0 = EmojiResHelper.c;
        EmojiResHelper r1 = EmojiResHelper.a.a(jc1.a.b().getApplicationContext());
        return r1.d(r1.c());
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public void preloadOnlineEmoji() {
        a r0 = a.a();
        r0.getClass();
        if ((System.currentTimeMillis() - r0.b.getLong("refresh_online_emoji_time", 0)) <= 86400000) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L11;
        OnlineSmallEmojiResManager r2 = OnlineSmallEmojiResManager.i;
        if (r2.g == true) goto L11;
        r2.g = true;
        a.a().b.edit().putLong("refresh_online_emoji_time", System.currentTimeMillis()).commit();
        ALogger.d("OnlineEmojiResManager", "  refreshEmoji start");
        l.d().getClass();
        ((OnlineEmojiApi) c.b().e(OnlineEmojiApi.class)).getSmallEmojiResources().subscribe(new i(r2));
    L11:
        OnlineSmallEmojiResManager r3 = OnlineSmallEmojiResManager.i;
        r3.getClass();
        Task.call(new h(r3, false), Task.UI_THREAD_EXECUTOR);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public Drawable getRealDrawable(String r3) {
        EmojiResHelper r0 = EmojiResHelper.c;
        return EmojiResHelper.a.a(jc1.a.b()).a(jc1.a.b(), r3);
    }

    @Override // com.bytedance.android.live.emoji.api.IAwemeEmojiProxy
    public void updateRecentEmoji(String r5) {
        List<String> r0 = f.a;
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L22;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        ArrayList r3 = new ArrayList();
        r2.element = r3;
        List<String> r4 = f.a;
        if (r4 == null) goto L15;
        r3.addAll(r4);
    L15:
        if (((ArrayList) r2.element).isEmpty() == false) goto L17;
        ((ArrayList) r2.element).add(r5);
    L20:
        f.a = (ArrayList) r2.element;
        Observable.create(new e(r2)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L17:
        ((ArrayList) r2.element).remove(r5);
        ListProtector.add((ArrayList) r2.element, 0, r5);
        if (((ArrayList) r2.element).size() <= 8) goto L20;
        List r6 = ((ArrayList) r2.element).subList(0, 8);
        ArrayList r7 = new ArrayList();
        r7.addAll(r6);
        r2.element = r7;
        goto L20
    L22:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
