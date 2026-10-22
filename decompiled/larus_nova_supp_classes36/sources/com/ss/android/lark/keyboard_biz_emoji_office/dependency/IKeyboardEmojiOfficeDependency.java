package com.ss.android.lark.keyboard_biz_emoji_office.dependency;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IKeyboardEmojiOfficeDependency {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final Lazy<IKeyboardEmojiOfficeDependency> b = null;

        public Companion() {
        }

        static {
            a = new Companion();
            b = LazyKt.lazy(IKeyboardEmojiOfficeDependency$Companion$instance$2.INSTANCE);
        }
    }

    static {
        a = Companion.a;
    }

    Fragment newCustomStickerFragment();
}
