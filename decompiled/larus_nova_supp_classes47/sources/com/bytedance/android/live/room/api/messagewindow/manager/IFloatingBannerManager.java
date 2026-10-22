package com.bytedance.android.live.room.api.messagewindow.manager;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IFloatingBannerManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/manager/IFloatingBannerManager$Element;", "", "PublicScreen", "EntryAnim", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Element extends Enum<Element> {
        public static final Element EntryAnim = null;
        public static final Element PublicScreen = null;
        public static final /* synthetic */ Element[] a = null;

        static {
            Element r1 = new Element("PublicScreen", 0);
            PublicScreen = r1;
            Element r2 = new Element("EntryAnim", 1);
            EntryAnim = r2;
            a = new Element[]{r1, r2};
        }

        public static Element valueOf(String r1) {
            return (Element) a.a(Element.class, r1);
        }

        public static Element[] values() {
            return (Element[]) a.clone();
        }

        public Element(String r1, int r2) {
            super(r1, r2);
        }
    }

    void H1(View r1);

    void I1(View r1, View r2, Element r3);

    ViewGroup getRootContainer();

    void n0(View r1);
}
