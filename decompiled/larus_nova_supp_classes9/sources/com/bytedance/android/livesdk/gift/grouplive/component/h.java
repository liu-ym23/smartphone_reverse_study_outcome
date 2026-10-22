package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements fa0.c, o {
    public final PublishSubject<fa0.b> a;
    public i b;
    public final CompositeDisposable c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final fa0.a o0() {
        i r0 = this.b;
        if (r0 == null) goto L40;
        if (r0.d.isAnchor() == true) goto L7;
    L37:
        fa0.a r2 = (fa0.a) r0.b.a;
    L38:
        if (r2 == null) goto L40;
        return r2;
    L7:
        if (((fa0.a) r0.b.a).a == true) goto L37;
        com.bytedance.android.livesdk.sharedpref.e<String> r3 = j.a;
        String r4 = r0.d.getRoom().getIdStr();
        Intrinsics.checkNotNullParameter(r4, "roomId");
        HashMap<String, fa0.a> r5 = j.b;
        if (r5.containsKey(r4) == false) goto L11;
        r2 = r5.get(r4);
    L35:
        if (r2 != null) goto L38;
        r2 = (fa0.a) r0.b.a;
        goto L38
    L11:
        String r6 = (String) j.a.getValue();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        Object r8 = Result.constructor-impl(new JSONObject(r6));     // Catch: Throwable -> L14
    L16:
        fa0.a r9 = null;
        if (Result.isFailure-impl(r8) == false) goto L19;
        r8 = null;
    L19:
        JSONObject r10 = (JSONObject) r8;
        boolean r11 = true;
        if (r6.length() != 0) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == true) goto L34;
        if (r10 == null) goto L34;
        if ((!Intrinsics.areEqual(r4, r10.optString("room_id"))) == true) goto L34;
        String r14 = r10.optString("payload");
        int r15 = r10.optInt("type", -1);
        if (r15 != (-1)) goto L33;
        r11 = false;
    L33:
        r9 = new fa0.a(r11, Integer.valueOf(r15), r14);
        j.b.put(r4, r9);
    L34:
        r2 = r9;
        goto L35
    L22:
        r13 = false;
    L14:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        return new fa0.a(0);
    }

    public h() {
        this.a = PublishSubject.create();
        this.c = new CompositeDisposable();
    }

    public final Observable<fa0.b> I4() {
        return this.a;
    }
}
