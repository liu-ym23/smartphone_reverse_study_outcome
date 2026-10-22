package p1c;

import android.content.Context;
import p1c.a;
import p1c.b;
import p1c.c;
import p1c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface e<ContactDep extends b, ChatDep extends a, PushDep extends d, PhoneDep extends c> {
    ChatDep getChatDependency();

    ContactDep getContactDependency();

    PhoneDep getPhoneDependency();

    PushDep getPushDependency();

    String getReportHost();

    void openUrlV2(Context r1, String r2);

    void peakFeedCard(String r1);
}
