package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.bmhome.utils.m3;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface s0 {

    public static final class a {
        public static /* synthetic */ Object b(s0 r6, Context r7, Message r8, BotModel r9, Continuation r10) {
            return r6.g(r7, r8, r9, TargetDataSource.Content, r10);
        }

        public static /* synthetic */ Object c(s0 r33, Context r34, List r35, boolean r36, m3 r37, Continuation r38, int r39) {
            if ((r39 & 8) == 0) goto L5;
            int r4 = com.larus.utils.m0.b(r34);
        L7:
            if ((r39 & 16) == 0) goto L9;
            lw8.d r6 = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
        L11:
            if ((r39 & 64) == 0) goto L13;
            boolean r8 = false;
        L15:
            if ((r39 & 128) == 0) goto L17;
            boolean r9 = true;
        L19:
            if ((r39 & 256) == 0) goto L21;
            m3 r10 = null;
        L23:
            return r33.d(r34, r35, true, r4, r6, null, r8, r9, r10, r38);
        L21:
            r10 = r37;
            goto L23
        L17:
            r9 = false;
            goto L19
        L13:
            r8 = r36;
            goto L15
        L9:
            r6 = null;
            goto L11
        L5:
            r4 = 0;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object a(s0 r9, List r10, boolean r11, String r12, boolean r13, Function1 r14, Continuation r15, int r16) {
            if ((r16 & 2) == 0) goto L5;
            boolean r4 = false;
        L7:
            if ((r16 & 4) == 0) goto L9;
            String r5 = "\n\n";
        L11:
            if ((r16 & 8) == 0) goto L13;
            boolean r6 = false;
        L15:
            if ((r16 & 16) == 0) goto L17;
            Function1 r7 = null;
        L19:
            return r9.c(r10, r4, r5, r6, r7, r15);
        L17:
            r7 = r14;
            goto L19
        L13:
            r6 = r13;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }
    }

    Object a(Message r1, String r2, TargetDataSource r3, Continuation<? super List<String>> r4);

    Object b(List<? extends lw8.l> r1, Continuation<? super String> r2);

    Object c(List<Block> r1, boolean r2, String r3, boolean r4, Function1<? super Block, String> r5, Continuation<? super List<String>> r6);

    Object d(Context r1, List<Block> r2, boolean r3, int r4, lw8.d r5, lw8.h r6, boolean r7, boolean r8, Function1<? super Block, String> r9, Continuation<? super List<? extends lw8.l>> r10);

    Object e(Context r1, List<? extends lw8.l> r2, String r3, Continuation<? super Unit> r4);

    boolean f(Context r1, CharSequence r2);

    Object g(Context r1, Message r2, BotModel r3, TargetDataSource r4, Continuation<? super List<? extends lw8.l>> r5);
}
