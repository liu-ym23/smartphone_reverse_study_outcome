package com.ss.android.token;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.utils.j;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TokenObjectProvider extends ContentProvider {
    public String a;
    public UriMatcher b;
    public volatile boolean c;

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    public TokenObjectProvider() {
        this.c = false;
    }

    public static String a(Context r5) {
        if (r5 != null) goto L16;
        return null;
    L16:
        ProviderInfo r1 = r5.getPackageManager().getProviderInfo(new ComponentName(r5.getPackageName(), TokenObjectProvider.class.getName()), 128);     // Catch: Exception -> L12
        if (r1 == null) goto L14;
        String r2 = r1.authority;     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r2) == true) goto L14;
        a.a("TokenObjectProvider", "set authority at getting ProviderInfo");     // Catch: Exception -> L12
        return r2;
    L14:
        a.a("TokenObjectProvider", "set authority at making");
        return r5.getPackageName() + ".TokenObjectProvider";
    L12:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L14
    }

    public final boolean b(Context r5) {
        if (this.c == false) goto L6;
        return true;
    L6:
        if (p.b == true) goto L8;
        return false;
    L8:
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L10:
        if (this.c == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L24
        return true;
    L14:
        if (TextUtils.isEmpty(this.a) == false) goto L17;
        this.a = a(r5);     // Catch: Throwable -> L24
    L17:
        if (TextUtils.isEmpty(this.a) == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L24
        return false;
    L20:
        a.a("TokenObjectProvider", "authority=" + this.a);     // Catch: Throwable -> L24
        UriMatcher r6 = new UriMatcher(-1);     // Catch: Throwable -> L24
        this.b = r6;     // Catch: Throwable -> L24
        r6.addURI(this.a, "get_token_object", 1);     // Catch: Throwable -> L24
        this.b.addURI(this.a, "set_token_object", 2);     // Catch: Throwable -> L24
        this.b.addURI(this.a, "save_last_token", 3);     // Catch: Throwable -> L24
        this.b.addURI(this.a, "get_last_same_user_token", 4);     // Catch: Throwable -> L24
        this.b.addURI(this.a, "clear_last_token", 5);     // Catch: Throwable -> L24
        this.c = true;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return this.c;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        b(getContext());
        return "vnd.android.cursor.item/vnd." + this.a + ".item";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r3, ProviderInfo r4) {
        if (r4 == null) goto L4;
        a.a("TokenObjectProvider", "set authority at attachInfo");
        this.a = r4.authority;
    L4:
        super.attachInfo(r3, r4);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        b(getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        b(getContext());
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r22, ContentValues r23, String r24, String[] r25) {
        if (b(getContext()) == true) goto L5;
        return 0;
    L5:
        int r2 = this.b.match(r22);
        a.a("TokenObjectProvider", "update, code=" + r2);
        if (r2 != 2) goto L37;
        TokenFactory r3 = TokenFactory.j();
        if (r3 == null) goto L65;
        e0 r4 = r3.o();
        if (r22 == null) goto L34;
        String r7 = UriProtector.getQueryParameter(r22, "token");
        String r8 = UriProtector.getQueryParameter(r22, "ts_sign");
        String r9 = UriProtector.getQueryParameter(r22, "attest_ts_sign");
        String r10 = UriProtector.getQueryParameter(r22, "token_encrypted");
        String r11 = UriProtector.getQueryParameter(r22, "token_hash");
        String r12 = UriProtector.getQueryParameter(r22, "track_data");
        String r13 = UriProtector.getQueryParameter(r22, "token_tlb_tag");
        String r0 = UriProtector.getQueryParameter(r22, "is_login");
        if (TextUtils.isEmpty(r0) == false) goto L68;
    L17:
        int r20 = -1;
    L19:
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        TicketTrackData.Serialized r15 = new TicketTrackData.Serialized(r12);
        if (r7 != null) goto L24;
        r7 = "";
    L24:
        if (r8 != null) goto L26;
        String r16 = "";
    L27:
        if (r9 != null) goto L29;
        String r17 = "";
    L30:
        if (r13 != null) goto L32;
        String r19 = "";
    L33:
        e0 r1 = new e0(r7, r16, r17, r15, r19, r20);
        r1.f = r10;
        r1.e = r11;
    L35:
        r3.C("content_provider", r1, null);
        TTTokenMonitor.b("sub_thread", r4.a);
        goto L65
    L32:
        r19 = r13;
        goto L33
    L29:
        r17 = r9;
        goto L30
    L26:
        r16 = r8;
        goto L27
    L68:
        r20 = CastIntegerProtector.parseInt(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        a.c("TokenObject", "parseFromUri(), parse isLogin fail", th);
        goto L17
    L34:
        r1 = new e0();
    L65:
        return 0;
    L37:
        if (r2 != 3) goto L42;
        TokenFactory r5 = TokenFactory.j();
        if (r5 == null) goto L65;
        r5.z(null);
        goto L65
    L42:
        if (r2 != 5) goto L65;
        TokenFactory r6 = TokenFactory.j();
        if (r6 == null) goto L65;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.r == false) goto L65;
        r6.t(true, "clearLastToken");
        r6.d.getClass();
        a.a("TokenFactory", "clear last token");
        if (r.b == false) goto L61;
        Object r14 = r.l;
        monitor-enter(r14);
        r.g = "";     // Catch: Throwable -> L58
        AuthTokenMultiProcessSharedProvider.b r18 = r.a;     // Catch: Throwable -> L58
        if (r18 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L58
    L55:
        AuthTokenMultiProcessSharedProvider.a r21 = r18.b();     // Catch: Throwable -> L58
        r21.c("x-tt-token-last", "");     // Catch: Throwable -> L58
        r21.a();     // Catch: Throwable -> L58
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r14);
    L58:
        th = move-exception;
        throw th;
    L61:
        f0 r27 = r.d;
        if (r27 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("tokenObjectProviderHelper");
    L64:
        r27.a();
        goto L65
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        if (b(getContext()) == true) goto L5;
        return null;
    L5:
        int r14 = this.b.match(r9);
        a.a("TokenObjectProvider", "query, code=" + r14);
        if (r14 != 1) goto L16;
        TokenFactory r15 = TokenFactory.j();
        if (r15 == null) goto L24;
        e0 r16 = r15.o();
        r16.getClass();
        MatrixCursor r17 = new MatrixCursor(new String[]{"token", "ts_sign", "attest_ts_sign", "token_encrypted", "token_hash", "track_data", "token_tlb_tag", "is_login"});
        MatrixCursor.RowBuilder r18 = r17.newRow().add(r16.a).add(r16.b).add(r16.c).add(r16.f).add(r16.e);
        j<TicketTrackData> r19 = r16.d;
        if (r19 != null) goto L12;
        String r110 = "";
    L13:
        r18.add(r110).add(r16.g).add(Integer.valueOf(r16.h));
        return r17;
    L12:
        r110 = r19.a();
    L24:
        return null;
    L16:
        if (r14 != 4) goto L24;
        TokenFactory r20 = TokenFactory.j();
        if (r20 == null) goto L24;
        String r21 = r20.k();
        MatrixCursor r111 = new MatrixCursor(new String[]{"last_token"});     // Catch: Exception -> L22
        r111.newRow().add(r21);     // Catch: Exception -> L22
        return r111;
    L22:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L24
    }
}
