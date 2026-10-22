package com.larus.audio.call.extension;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;
import r68.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class WakeupAudioAuthSessionController {
    public volatile boolean a;
    public volatile boolean b;
    public volatile String c;
    public final Object d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/extension/WakeupAudioAuthSessionController$QueryEndAction;", "", "<init>", "(Ljava/lang/String;I)V", "END_SESSION", "RESET_FOR_NEXT_QUERY", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum QueryEndAction extends Enum<QueryEndAction> {
        public static final QueryEndAction END_SESSION = null;
        public static final QueryEndAction RESET_FOR_NEXT_QUERY = null;
        public static final /* synthetic */ QueryEndAction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<QueryEndAction> getEntries() {
            return b;
        }

        static {
            QueryEndAction r0 = new QueryEndAction("END_SESSION", 0);
            END_SESSION = r0;
            QueryEndAction r1 = new QueryEndAction("RESET_FOR_NEXT_QUERY", 1);
            RESET_FOR_NEXT_QUERY = r1;
            QueryEndAction[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static QueryEndAction[] values() {
            return (QueryEndAction[]) a.clone();
        }

        public static QueryEndAction valueOf(String r1) {
            return (QueryEndAction) a.a(QueryEndAction.class, r1);
        }

        public QueryEndAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final void a() {
        Object r0 = this.d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.b == true) goto L7;
    L13:
        monitor-exit(r0);
        return;
    L7:
        if (this.a == true) goto L13;
        this.b = false;     // Catch: Throwable -> L15
        this.a = true;     // Catch: Throwable -> L15
        String r1 = this.c;     // Catch: Throwable -> L15
        monitor-exit(r0);
        b.a.a(r1);
    }

    public WakeupAudioAuthSessionController() {
        this.d = new Object();
    }

    public final void b(boolean r3, long r4, boolean r6) {
        if (r3 == true) goto L4;
        return;
    L4:
        if (r4 == 0) goto L17;
        boolean r5 = b.a.c(r4, r6);
        Object r7 = this.d;
        monitor-enter(r7);
        this.b = r5;     // Catch: Throwable -> L11
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r7);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
