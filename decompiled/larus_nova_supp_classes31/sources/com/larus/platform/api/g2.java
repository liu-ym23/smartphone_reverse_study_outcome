package com.larus.platform.api;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.larus.platform.api.creation.CreateCreationSource;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.uaigc.createpage.component.input.CreationInputComponent$tryShowUpdateDialog$1;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import zp9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface g2 {

    public static final class a {
        public static /* synthetic */ CreationFeedCacheEntity b(String r2) {
            return com.larus.platform.service.e0.a.b1(r2, true);
        }

        public static /* synthetic */ Object a(String r9, int r10, String r11, int r12, String r13, int r14, Continuation r15, int r16) {
            com.larus.platform.service.e0 r0 = com.larus.platform.service.e0.a;
            if ((r16 & 16) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r16 & 32) == 0) goto L9;
            int r6 = 1;
        L11:
            return r0.l(r9, r10, r11, r12, r5, r6, null, r15);
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L7
        }
    }

    void X0(String r1);

    boolean Y0(int r1, FragmentManager r2, String r3, String r4, boolean r5, Integer r6, CreationInputComponent$tryShowUpdateDialog$1.a r7);

    gs9.g a(gs9.c r1, gs9.d r2);

    void a1(PublisherCreation r1, PublisherTrackParams r2);

    Object b(String r1, boolean r2, Continuation<? super Pair<Boolean, String>> r3);

    CreationFeedCacheEntity b1(String r1, boolean r2);

    Object c(Long r1, Long r2, String r3, Integer r4, ContinuationImpl r5);

    void c1(r r1);

    void d(Context r1, nr9.g r2, String r3, String r4, String r5, String r6, Map<String, String> r7);

    void d1();

    void e(int r1, boolean r2, Function1<? super Boolean, Unit> r3);

    void e1(r r1);

    void f();

    Object g(String r1, Continuation<? super Pair<Boolean, String>> r2);

    void g1(PublisherCreation r1);

    Object h(String r1, int r2, Continuation<? super Pair<Boolean, String>> r3);

    Object h1(String r1, String r2, String r3, Continuation<? super Unit> r4);

    Object i(String r1, Map<String, String> r2, Continuation<? super Unit> r3);

    kotlinx.coroutines.flow.i1<CreationFeedCacheEntity> i1(String r1);

    boolean j();

    Object k(String r1, String r2, String r3, ContinuationImpl r4);

    Object l(String r1, int r2, String r3, int r4, String r5, @CreateCreationSource int r6, String r7, Continuation<? super zp9.a> r8);
}
