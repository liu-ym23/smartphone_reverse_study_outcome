package com.ss.android.lark.keyboard.keyboard2.content;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IKeyboardContent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/content/IKeyboardContent$ViewInitStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "Lazy", "Idle", "Immediate", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ViewInitStrategy extends Enum<ViewInitStrategy> {
        public static final ViewInitStrategy Idle = null;
        public static final ViewInitStrategy Immediate = null;
        public static final ViewInitStrategy Lazy = null;
        public static final /* synthetic */ ViewInitStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ViewInitStrategy> getEntries() {
            return b;
        }

        static {
            ViewInitStrategy r0 = new ViewInitStrategy("Lazy", 0);
            Lazy = r0;
            ViewInitStrategy r1 = new ViewInitStrategy("Idle", 1);
            Idle = r1;
            ViewInitStrategy r3 = new ViewInitStrategy("Immediate", 2);
            Immediate = r3;
            ViewInitStrategy[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ViewInitStrategy[] values() {
            return (ViewInitStrategy[]) a.clone();
        }

        public static ViewInitStrategy valueOf(String r1) {
            return (ViewInitStrategy) r27.a.a(ViewInitStrategy.class, r1);
        }

        public ViewInitStrategy(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        String getTag();
    }

    ViewInitStrategy a();

    View b(ViewGroup r1);

    void c(int r1);

    a getKey();

    void onActivityResult(int r1, int r2, Intent r3);

    void onConfigurationChanged(Configuration r1);

    void onCreate();

    void onDestroy();

    void onHide();

    void onShow();
}
