package com.bytedance.ai.applet.app.base;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface ApplicationRouter {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/applet/app/base/ApplicationRouter$Mode;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NAVIGATE", "REDIRECT", "RELAUNCH", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode NAVIGATE = null;
        public static final Mode REDIRECT = null;
        public static final Mode RELAUNCH = null;
        public static final /* synthetic */ Mode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<Mode> getEntries() {
            return b;
        }

        static {
            Mode r0 = new Mode("NAVIGATE", 0, "navigate");
            NAVIGATE = r0;
            Mode r1 = new Mode("REDIRECT", 1, "redirect");
            REDIRECT = r1;
            Mode r10 = new Mode("RELAUNCH", 2, "relaunch");
            RELAUNCH = r10;
            Mode[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
        }

        public Mode(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "", "<init>", "(Ljava/lang/String;I)V", "PUSH", "REPLACE", "NAVIGATE", "POP_TO", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OpenPageMode extends Enum<OpenPageMode> {
        public static final OpenPageMode NAVIGATE = null;
        public static final OpenPageMode POP_TO = null;
        public static final OpenPageMode PUSH = null;
        public static final OpenPageMode REPLACE = null;
        public static final /* synthetic */ OpenPageMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<OpenPageMode> getEntries() {
            return b;
        }

        static {
            OpenPageMode r0 = new OpenPageMode("PUSH", 0);
            PUSH = r0;
            OpenPageMode r1 = new OpenPageMode("REPLACE", 1);
            REPLACE = r1;
            OpenPageMode r10 = new OpenPageMode("NAVIGATE", 2);
            NAVIGATE = r10;
            OpenPageMode r11 = new OpenPageMode("POP_TO", 3);
            POP_TO = r11;
            OpenPageMode[] r12 = {r0, r1, r10, r11};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static OpenPageMode[] values() {
            return (OpenPageMode[]) a.clone();
        }

        public static OpenPageMode valueOf(String r1) {
            return (OpenPageMode) r27.a.a(OpenPageMode.class, r1);
        }

        public OpenPageMode(String r1, int r10) {
            super(r1, r10);
        }
    }

    Object b(String r1, OpenPageMode r10, RouteOptions r11, Continuation<? super Result<Unit>> r12);

    Object c(String r1, RouteOptions r10, Continuation<? super Result<Unit>> r11);

    Object e(String r1, RouteOptions r10, Continuation<? super Result<Unit>> r11);

    Object f();

    Object i(String r1, RouteOptions r10, Continuation<? super Result<Unit>> r11);

    Object j(RouteOptions r1, Continuation<? super Result<Unit>> r10);

    void k(long r1);

    Object l(Continuation<? super Result<Unit>> r1);

    Object m(int r1);

    void n(long r1, String r10);
}
