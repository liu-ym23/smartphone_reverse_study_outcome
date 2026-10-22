package com.ss.android.lark.keyboard.plugin.tool.face;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IFaceDependency {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/IFaceDependency$EmojiScene;", "", "value", "Lcom/ss/android/lark/statistics/extensions/IParam;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/statistics/extensions/IParam;)V", "getValue", "()Lcom/ss/android/lark/statistics/extensions/IParam;", "setValue", "(Lcom/ss/android/lark/statistics/extensions/IParam;)V", "IM", "MOMENTS", "TODO", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum EmojiScene extends Enum<EmojiScene> {
        public static final EmojiScene IM = null;
        public static final EmojiScene MOMENTS = null;
        public static final EmojiScene TODO = null;
        public static final /* synthetic */ EmojiScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private s5c.d value;

        public static EnumEntries<EmojiScene> getEntries() {
            return b;
        }

        static {
            EmojiScene r0 = new EmojiScene("IM", 0, z2.c);
            IM = r0;
            EmojiScene r1 = new EmojiScene("MOMENTS", 1, z2.e);
            MOMENTS = r1;
            EmojiScene r2 = new EmojiScene("TODO", 2, z2.f);
            TODO = r2;
            EmojiScene[] r4 = {r0, r1, r2};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static EmojiScene[] values() {
            return (EmojiScene[]) a.clone();
        }

        public final s5c.d getValue() {
            return this.value;
        }

        public static EmojiScene valueOf(String r1) {
            return (EmojiScene) r27.a.a(EmojiScene.class, r1);
        }

        public final void setValue(s5c.d r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.value = r2;
        }

        public EmojiScene(String r1, int r2, s5c.a r3) {
            super(r1, r2);
            this.value = r3;
        }
    }
}
