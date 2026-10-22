package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class PanelMenuItem extends o {
    public final InitialStrategy c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/PanelMenuItem$InitialStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "Lazy", "Idle", "Immediate", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum InitialStrategy extends Enum<InitialStrategy> {
        public static final InitialStrategy Idle = null;
        public static final InitialStrategy Immediate = null;
        public static final InitialStrategy Lazy = null;
        public static final /* synthetic */ InitialStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<InitialStrategy> getEntries() {
            return b;
        }

        static {
            InitialStrategy r0 = new InitialStrategy("Lazy", 0);
            Lazy = r0;
            InitialStrategy r1 = new InitialStrategy("Idle", 1);
            Idle = r1;
            InitialStrategy r3 = new InitialStrategy("Immediate", 2);
            Immediate = r3;
            InitialStrategy[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static InitialStrategy[] values() {
            return (InitialStrategy[]) a.clone();
        }

        public static InitialStrategy valueOf(String r1) {
            return (InitialStrategy) r27.a.a(InitialStrategy.class, r1);
        }

        public InitialStrategy(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract View G(ViewGroup r1);

    public PanelMenuItem() {
        this.c = InitialStrategy.Lazy;
    }

    public InitialStrategy C() {
        return this.c;
    }
}
