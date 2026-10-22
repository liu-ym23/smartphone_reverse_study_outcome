package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IBubbleBodyBgStyleProvider {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cellv2/layout/bubble/IBubbleBodyBgStyleProvider$Style;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Normal", "Clean", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style Clean = null;
        public static final Style Normal = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style("Normal", 0);
            Normal = r0;
            Style r1 = new Style("Clean", 1);
            Clean = r1;
            Style[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) a.a(Style.class, r1);
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    Style m();
}
