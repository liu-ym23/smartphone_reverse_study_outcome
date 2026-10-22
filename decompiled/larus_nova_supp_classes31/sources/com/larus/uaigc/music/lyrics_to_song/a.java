package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContentList;
import kotlin.jvm.internal.Intrinsics;
import xc8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class a extends h {
    public static final /* synthetic */ int p = 0;

    public abstract void n(Message r1, q0 r2, wc9.e r3, boolean r4, MusicCreationContentList r5, Fragment r6);

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        super(r2);
    }
}
