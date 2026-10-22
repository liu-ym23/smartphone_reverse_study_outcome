package com.larksuite.component.card.service;

import com.larksuite.component.card.service.c;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface ICardServiceFactory<T extends c> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/service/ICardServiceFactory$Scope;", "", "<init>", "(Ljava/lang/String;I)V", "CARD", "LIFECYCLE", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Scope extends Enum<Scope> {
        public static final Scope CARD = null;
        public static final Scope LIFECYCLE = null;
        public static final /* synthetic */ Scope[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Scope> getEntries() {
            return b;
        }

        static {
            Scope r0 = new Scope("CARD", 0);
            CARD = r0;
            Scope r1 = new Scope("LIFECYCLE", 1);
            LIFECYCLE = r1;
            Scope[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Scope[] values() {
            return (Scope[]) a.clone();
        }

        public static Scope valueOf(String r1) {
            return (Scope) r27.a.a(Scope.class, r1);
        }

        public Scope(String r1, int r2) {
            super(r1, r2);
        }
    }

    Scope a();

    T b(b r1);
}
