package com.ss.android.lark.maintab.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface ITabTitleConfig {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/maintab/export/ITabTitleConfig$IconStyle;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "Hide", "Up", "Down", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum IconStyle extends Enum<IconStyle> {
        public static final a Companion = null;
        public static final IconStyle Down = null;
        public static final IconStyle Hide = null;
        public static final IconStyle Up = null;
        public static final /* synthetic */ IconStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<IconStyle> getEntries() {
            return b;
        }

        static {
            IconStyle r0 = new IconStyle("Hide", 0, 0);
            Hide = r0;
            IconStyle r1 = new IconStyle("Up", 1, 1);
            Up = r1;
            IconStyle r3 = new IconStyle("Down", 2, 2);
            Down = r3;
            IconStyle[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static IconStyle[] values() {
            return (IconStyle[]) a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static IconStyle valueOf(String r1) {
            return (IconStyle) r27.a.a(IconStyle.class, r1);
        }

        public IconStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/maintab/export/ITabTitleConfig$Status;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "Normal", "Loading", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Status extends Enum<Status> {
        public static final a Companion = null;
        public static final Status Loading = null;
        public static final Status Normal = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("Normal", 0, 0);
            Normal = r0;
            Status r1 = new Status("Loading", 1, 1);
            Loading = r1;
            Status[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }
}
