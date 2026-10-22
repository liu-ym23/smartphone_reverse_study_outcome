package com.bytedance.android.live.ktv.common.model.bean;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.UserHighScoreSongTag;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/d;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "f", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "", "orderSongs", "Ljava/util/List;", "getOrderSongs", "()Ljava/util/List;", "setOrderSongs", "(Ljava/util/List;)V", "applyTime", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setApplyTime", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "highScoreSongTag", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "d", "()Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "setHighScoreSongTag", "(Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;)V", "Lcom/bytedance/android/live/ktv/common/model/bean/i;", "userMultiChorusSong", "Lcom/bytedance/android/live/ktv/common/model/bean/i;", "getUserMultiChorusSong", "()Lcom/bytedance/android/live/ktv/common/model/bean/i;", "setUserMultiChorusSong", "(Lcom/bytedance/android/live/ktv/common/model/bean/i;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements vh7.h {

    @SerializedName("apply_time_text")
    protected String applyTime;

    @SerializedName("high_score_song_tag")
    protected UserHighScoreSongTag highScoreSongTag;

    @SerializedName("ordered_song_names")
    protected List<String> orderSongs;

    @SerializedName("user")
    protected IBaseUser user;

    @SerializedName("multi_chorus_song_info")
    protected i userMultiChorusSong;

    public d() {
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public d(am3.g r5) {
        this.orderSongs = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.user = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.orderSongs.add(am3.h.c(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.applyTime = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.highScoreSongTag = new UserHighScoreSongTag(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.userMultiChorusSong = new i(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }

    public final String b() {
        i r0 = this.userMultiChorusSong;
        if (r0 == null) goto L10;
        List<e> r1 = r0.songList;
        if (r1 == null) goto L10;
        e r2 = (e) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L10;
        String r3 = String.valueOf(r2.songId);
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "";
    }

    public final String c() {
        i r0 = this.userMultiChorusSong;
        if (r0 == null) goto L5;
        List<e> r1 = r0.songList;
    L6:
        List<e> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L24;
        i r4 = this.userMultiChorusSong;
        if (r4 == null) goto L31;
        List<e> r5 = r4.songList;
        if (r5 == null) goto L32;
        e r6 = (e) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L33;
        String r7 = r6.songName;
        if (r7 != null) goto L30;
        return "";
    L30:
        return r7;
    L33:
        return "";
    L32:
        return "";
    L31:
        return "";
    L24:
        List<String> r8 = this.orderSongs;
        if (r8 == null) goto L34;
        r7 = (String) CollectionsKt.firstOrNull(r8);
        if (r7 != null) goto L30;
        return "";
    L34:
        return "";
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final long e() {
        i r0 = this.userMultiChorusSong;
        if (r0 == null) goto L5;
        List<e> r1 = r0.songList;
    L6:
        List<e> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L18;
        i r4 = this.userMultiChorusSong;
        if (r4 != null) goto L23;
        return 0;
    L23:
        return r4.totalCount;
    L18:
        List<String> r5 = this.orderSongs;
        if (r5 != null) goto L21;
        return 0;
    L21:
        return r5.size();
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final int hashCode() {
        IBaseUser r0 = this.user;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.orderSongs;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.applyTime;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        UserHighScoreSongTag r11 = this.highScoreSongTag;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        i r14 = this.userMultiChorusSong;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String a() {
        return this.applyTime;
    }

    public final UserHighScoreSongTag d() {
        return this.highScoreSongTag;
    }

    public final IBaseUser f() {
        return this.user;
    }

    public final boolean equals(Object r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (this != r6) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(d.class, r6.getClass())) == false) goto L11;
        return false;
    L11:
        d r7 = (d) r6;
        IBaseUser r2 = this.user;
        String r3 = null;
        if (r2 == null) goto L14;
        String r4 = r2.getIdString();
    L15:
        IBaseUser r5 = r7.user;
        if (r5 == null) goto L19;
        r3 = r5.getIdString();
    L19:
        if ((!Intrinsics.areEqual(r4, r3)) == false) goto L22;
        return false;
    L22:
        if ((!Intrinsics.areEqual(this.orderSongs, r7.orderSongs)) == false) goto L25;
        return false;
    L25:
        if ((!Intrinsics.areEqual(this.applyTime, r7.applyTime)) == false) goto L28;
        return false;
    L28:
        if ((!Intrinsics.areEqual(this.highScoreSongTag, r7.highScoreSongTag)) == false) goto L31;
        return false;
    L31:
        if ((!Intrinsics.areEqual(this.userMultiChorusSong, r7.userMultiChorusSong)) == false) goto L33;
        return false;
    L33:
        return true;
    L14:
        r4 = null;
        goto L15
    }
}
