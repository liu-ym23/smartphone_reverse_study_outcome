package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final long h;
    public final long i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final String n;
    public final Episode o;

    public a(Bundle r15) {
        Intrinsics.checkNotNullParameter(r15, "args");
        this.a = r15.getString("live.intent.extra.ENTER_TYPE", "click");
        this.b = r15.getString(VSConstants.EXTRA_ENTER_LIVE_SOURCE, "");
        String r2 = null;
        if (r15.getString(VSConstants.EXTRA_ENTER_FROM_MERGE_RECOMMEND, null) == null) goto L5;
        String r0 = r15.getString(VSConstants.EXTRA_ENTER_FROM_MERGE_RECOMMEND, "");
    L10:
        this.c = r15.getString(VSConstants.EXTRA_VS_ENTER_FROM_MERGE, "");
        if (TextUtils.isEmpty(r15.getString("enter_from_ad_type")) == false) goto L16;
        Bundle r4 = r15.getBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r4 == null) goto L15;
        String r3 = r4.getString("enter_from_ad_type");
    L17:
        this.d = r3;
        this.e = r15.getString(VSConstants.EXTRA_VS_ENTER_METHOD, "");
        r15.getString(VSConstants.EXTRA_SOURCE_TYPE);
        r15.getLong(VSConstants.EXTRA_ENTER_FROM_USER_ID, 0);
        String r5 = r15.getString(VSConstants.EXTRA_VS_REQUEST_ID, null);
        this.f = r5;
        String r6 = r15.getString(VSConstants.EXTRA_VS_LOG_PB, null);
        this.g = r6;
        long r7 = r15.getLong(VSConstants.EXTRA_USER_FROM, 0);
        this.h = r15.getLong("live.intent.extra.VS_START_PLAY_POSITION", -1);
        this.i = r15.getLong("live.intent.extra.VS_START_HIGHLIGHT_POSITION", -1);
        r15.getString("live.intent.extra.VS_START_PLAY_DESCRIPTION", "");
        String r9 = r15.getString("live.intent.extra.EXTRA_VS_SCHEMA_PRE_REQUEST_STATUS", "");
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        this.j = r9;
        this.k = r15.getBoolean("live.intent.extra.VS_START_FROM_MODEL_MATCH", false);
        Bundle r10 = r15.getBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        this.m = r15.getBoolean(VSConstants.BUNDLE_FROM_NOTIFICATION, false);
        String r12 = "default";
        if (r15.getString("live.intent.extra.EXTRA_VS_ENTER_TYPE", null) == null) goto L23;
        r12 = r15.getString("live.intent.extra.EXTRA_VS_ENTER_TYPE", "default");
    L29:
        this.n = r12;
        if (TextUtils.isEmpty(r5) == false) goto L39;
        if (r10 == null) goto L34;
        String r8 = r10.getString(VSConstants.EXTRA_VS_REQUEST_ID);
        if (r8 == null) goto L34;
    L37:
        this.f = r8;
    L34:
        if (r10 == null) goto L36;
        r8 = r10.getString(VSConstants.EXTRA_ENTER_REQUEST_ID, "");
        goto L37
    L36:
        r8 = null;
    L39:
        if (TextUtils.isEmpty(r6) == false) goto L48;
        if (r10 == null) goto L43;
        String r11 = r10.getString(VSConstants.EXTRA_VS_LOG_PB);
        if (r11 == null) goto L43;
    L46:
        this.g = r11;
    L43:
        if (r10 == null) goto L45;
        r11 = r10.getString(VSConstants.EXTRA_ENTER_LOG_PB, "");
        goto L46
    L45:
        r11 = null;
    L48:
        if (r7 != 0) goto L51;
        if (r10 == null) goto L51;
        r10.getLong(VSConstants.EXTRA_USER_FROM, 0);
    L51:
        if (r0 != null) goto L55;
        if (r10 == null) goto L55;
        r10.getString(VSConstants.EXTRA_ENTER_FROM_MERGE_RECOMMEND, "");
    L55:
        if (r15.getString(VSConstants.EXTRA_VIDEO_MODEL) != null) goto L57;
    L72:
        this.o = (Episode) GsonProtectorUtils.fromJson(r.n().d(), r15.getString(VSConstants.EXTRA_VS_EPISODE), Episode.class);     // Catch: JsonSyntaxException -> L71
        return;
    L74:
        return;
    L57:
        if (r15.getLong(VSConstants.EXTRA_ITEM_ID, 0) <= 0) goto L72;
        if (r15.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.VS_DEFAULT) == VSConstants.VS_DEFAULT) goto L72;
        if (TextUtils.isEmpty(r15.getString("live.intent.extra.EXTRA_VS_ENTER_TYPE", "")) == false) goto L68;
        Bundle r1 = r15.getBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r1 == null) goto L66;
        r2 = r1.getString("live.intent.extra.EXTRA_VS_ENTER_TYPE", "");
    L66:
        if (TextUtils.isEmpty(r2) == false) goto L68;
        this.n = "episode_data";
    L68:
        this.l = true;
        goto L72
    L23:
        Bundle r13 = r15.getBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r13 == null) goto L29;
        String r14 = r13.getString("live.intent.extra.EXTRA_VS_ENTER_TYPE", "default");
        if (r14 == null) goto L29;
        r12 = r14;
        goto L29
    L15:
        r3 = null;
        goto L17
    L16:
        r3 = r15.getString("enter_from_ad_type");
        goto L17
    L5:
        Bundle r16 = r15.getBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r16 == null) goto L9;
        r0 = r16.getString(VSConstants.EXTRA_ENTER_FROM_MERGE_RECOMMEND, "");
        if (r0 != null) goto L10;
    L9:
        r0 = "";
        goto L10
    }
}
