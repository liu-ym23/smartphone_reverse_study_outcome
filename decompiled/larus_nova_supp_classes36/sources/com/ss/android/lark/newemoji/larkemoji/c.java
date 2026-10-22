package com.ss.android.lark.newemoji.larkemoji;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final ReentrantLock a = null;
    public static final Map<String, MutableLiveData<String>> b = null;
    public static final List<ssb.c> c = null;

    static {
        a = new ReentrantLock();
        b = new LinkedHashMap();
        c = new ArrayList();
    }

    public static void b() {
        Unit r0 = (Unit) g(LarkEmojiSource$notifyEmojiDataChange$1.INSTANCE);
    }

    public static MutableLiveData a(String r2) {
        LinkedHashMap r0 = (LinkedHashMap) b;
        Object r1 = r0.get(r2);
        if (r1 != null) goto L6;
        r1 = new MutableLiveData(r2);
        r0.put(r2, r1);
    L6:
        return (MutableLiveData) r1;
    }

    public static void c(final EmojiListView r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        Unit r2 = (Unit) g(new LarkEmojiSource$registerEmojiDataChangeListener$1(r1));
    }

    public static b d(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return new b(r2, a(r2));
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void e(final ssb.c r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        Unit r2 = (Unit) g(new LarkEmojiSource$unRegisterEmojiDataChangeListener$1(r1));
    }

    public static Object g(Function0 r3) {
        ReentrantLock r1 = a;     // Catch: Throwable -> L6 Exception -> L8
        r1.lock();     // Catch: Throwable -> L6 Exception -> L8
        Object r4 = r3.invoke();     // Catch: Throwable -> L6 Exception -> L8
        r1.unlock();
        return r4;
    L8:
        e = move-exception;
        Log.e("LarkEmojiSource", "withLock: " + e.getMessage());     // Catch: Throwable -> L6
        a.unlock();
        return null;
    L6:
        th = move-exception;
        a.unlock();
        throw th;
    }

    public static void f(final String r1, final String r2) {
        Intrinsics.checkNotNullParameter(r1, "emojiId");
        Intrinsics.checkNotNullParameter(r2, "updatedSkinedKey");
        Unit r3 = (Unit) g(new LarkEmojiSource$updateReactionSkin$1(r1, r2));
    }
}
