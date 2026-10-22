package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Notification.Builder f1630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f1631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f1632c;

    public l(j r22) {
        l r8 = this;
        new ArrayList();
        r8.f1632c = new Bundle();
        r8.f1631b = r22;
        Context r10 = r22.f1609a;
        Context r11 = r22.f1609a;
        String r12 = r22.f1625q;
        Notification.Builder r13 = new Notification.Builder(r11, r12);
        r8.f1630a = r13;
        Notification r14 = r22.f1627s;
        Notification.Builder r15 = r13.setWhen(r14.when).setSmallIcon(r14.icon, r14.iconLevel).setContent(r14.contentView).setTicker(r14.tickerText, null).setVibrate(r14.vibrate).setLights(r14.ledARGB, r14.ledOnMS, r14.ledOffMS);
        boolean r16 = true;
        int r17 = 0;
        if ((r14.flags & 2) == 0) goto L5;
        boolean r18 = true;
    L6:
        Notification.Builder r19 = r15.setOngoing(r18);
        if ((r14.flags & 8) == 0) goto L9;
        boolean r20 = true;
    L10:
        Notification.Builder r21 = r19.setOnlyAlertOnce(r20);
        if ((r14.flags & 16) == 0) goto L13;
        boolean r23 = true;
    L14:
        Notification.Builder r24 = r21.setAutoCancel(r23).setDefaults(r14.defaults).setContentTitle(r22.f1613e).setContentText(r22.f1614f).setContentInfo(null).setContentIntent(null).setDeleteIntent(r14.deleteIntent);
        if ((r14.flags & 128) != 0) goto L18;
        r16 = false;
    L18:
        r24.setFullScreenIntent(null, r16).setLargeIcon(null).setNumber(0).setProgress(r22.f1619k, r22.f1620l, r22.f1621m);
        r13.setSubText(r22.f1618j).setUsesChronometer(false).setPriority(r22.f1615g);
        Iterator<h> r25 = r22.f1610b.iterator();
    L19:
        String r26 = "";
        String r27 = "android.support.allowGeneratedReplies";
        if (r25.hasNext() == false) goto L44;
        h r28 = r25.next();
        if (r28.f1592b != null) goto L26;
        int r110 = r28.f1598h;
        if (r110 == 0) goto L26;
        r28.f1592b = IconCompat.a("", r110);
    L26:
        IconCompat r29 = r28.f1592b;
        if (r29 == null) goto L29;
        Icon r30 = IconCompat.a.c(r29, null);
    L30:
        Notification.Action.Builder r111 = new Notification.Action.Builder(r30, r28.f1599i, r28.f1600j);
        q[] r31 = r28.f1593c;
        if (r31 == null) goto L39;
        int r112 = r31.length;
        RemoteInput[] r113 = new RemoteInput[r112];
        int r114 = 0;
    L34:
        if (r114 >= r31.length) goto L36;
        r113[r114] = q.a(r31[r114]);
        r114 = r114 + 1;
        goto L34
    L36:
        int r32 = 0;
    L37:
        if (r32 >= r112) goto L39;
        r111.addRemoteInput(r113[r32]);
        r32 = r32 + 1;
    L39:
        Bundle r115 = r28.f1591a;
        if (r115 == null) goto L42;
        Bundle r33 = new Bundle(r115);
    L43:
        boolean r116 = r28.f1594d;
        r33.putBoolean("android.support.allowGeneratedReplies", r116);
        r111.setAllowGeneratedReplies(r116);
        int r117 = r28.f1596f;
        r33.putInt("android.support.action.semanticAction", r117);
        r111.setSemanticAction(r117);
        r111.setContextual(r28.f1597g);
        r111.setAuthenticationRequired(r28.f1601k);
        r33.putBoolean("android.support.action.showsUserInterface", r28.f1595e);
        r111.addExtras(r33);
        r8.f1630a.addAction(r111.build());
        goto L19
    L42:
        r33 = new Bundle();
        goto L43
    L29:
        r30 = null;
        goto L30
    L44:
        Bundle r34 = r22.f1623o;
        if (r34 == null) goto L47;
        r8.f1632c.putAll(r34);
    L47:
        r8.f1630a.setShowWhen(r22.f1616h);
        r8.f1630a.setLocalOnly(false).setGroup(null).setGroupSummary(false).setSortKey(null);
        r8.f1630a.setCategory(r22.f1622n).setColor(r22.f1624p).setVisibility(0).setPublicVersion(null).setSound(r14.sound, r14.audioAttributes);
        ArrayList<String> r35 = r22.f1628t;
        if (r35 != null) goto L50;
    L55:
        ArrayList<h> r36 = r22.f1612d;
        if (r36.size() > 0) goto L58;
        String r210 = r12;
    L93:
        r8.f1630a.setExtras(r22.f1623o).setRemoteInputHistory(null);
        r8.f1630a.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(0);
        if (TextUtils.isEmpty(r210) == true) goto L96;
        r8.f1630a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L96:
        Iterator<o> r37 = r22.f1611c.iterator();
    L98:
        if (r37.hasNext() == false) goto L100;
        o r38 = r37.next();
        Notification.Builder r39 = r8.f1630a;
        r38.getClass();
        r39.addPerson(o.a.b(r38));
        goto L98
    L100:
        r8.f1630a.setAllowSystemGeneratedContextualActions(r22.f1626r);
        r8.f1630a.setBubbleMetadata(null);
        return;
    L58:
        if (r22.f1623o != null) goto L60;
        r22.f1623o = new Bundle();
    L60:
        Bundle r40 = r22.f1623o.getBundle("android.car.EXTENSIONS");
        if (r40 != null) goto L63;
        r40 = new Bundle();
    L63:
        Bundle r41 = new Bundle(r40);
        Bundle r118 = new Bundle();
    L65:
        if (r17 >= r36.size()) goto L88;
        String r119 = Integer.toString(r17);
        h r120 = r36.get(r17);
        Object r121 = m.f1633a;
        Bundle r122 = new Bundle();
        if (r120.f1592b != null) goto L71;
        int r123 = r120.f1598h;
        if (r123 == 0) goto L71;
        r120.f1592b = IconCompat.a(r26, r123);
    L71:
        IconCompat r124 = r120.f1592b;
        if (r124 == null) goto L74;
        int r125 = r124.b();
    L75:
        r122.putInt("icon", r125);
        r122.putCharSequence("title", r120.f1599i);
        r122.putParcelable("actionIntent", r120.f1600j);
        Bundle r126 = r120.f1591a;
        if (r126 == null) goto L78;
        Bundle r127 = new Bundle(r126);
    L79:
        r127.putBoolean(r27, r120.f1594d);
        r122.putBundle("extras", r127);
        q[] r128 = r120.f1593c;
        if (r128 != null) goto L82;
        Bundle[] r129 = null;
        String r211 = r12;
    L87:
        r122.putParcelableArray("remoteInputs", r129);
        r122.putBoolean("showsUserInterface", r120.f1595e);
        r122.putInt("semanticAction", r120.f1596f);
        r118.putBundle(r119, r122);
        r17 = r17 + 1;
        r36 = r36;
        r27 = r27;
        r26 = r26;
        r12 = r211;
        goto L65
    L82:
        Bundle[] r42 = new Bundle[r128.length];
        int r43 = 0;
    L84:
        if (r43 >= r128.length) goto L86;
        q r44 = r128[r43];
        q[] r130 = r128;
        Bundle r131 = new Bundle();
        r44.getClass();
        r131.putString("resultKey", null);
        r131.putCharSequence("label", null);
        r131.putCharSequenceArray("choices", null);
        r131.putBoolean("allowFreeFormInput", false);
        r131.putBundle("extras", null);
        r42[r43] = r131;
        r43 = r43 + 1;
        r128 = r130;
        r12 = r12;
        goto L84
    L86:
        r211 = r12;
        r129 = r42;
        goto L87
    L78:
        r127 = new Bundle();
        goto L79
    L74:
        r125 = 0;
        goto L75
    L88:
        r210 = r12;
        r40.putBundle("invisible_actions", r118);
        r41.putBundle("invisible_actions", r118);
        if (r22.f1623o != null) goto L91;
        r22.f1623o = new Bundle();
    L91:
        r22.f1623o.putBundle("android.car.EXTENSIONS", r40);
        r8 = this;
        r8.f1632c.putBundle("android.car.EXTENSIONS", r41);
        goto L93
    L50:
        if (r35.isEmpty() == true) goto L55;
        Iterator<String> r45 = r35.iterator();
    L53:
        if (r45.hasNext() == false) goto L55;
        r8.f1630a.addPerson(r45.next());
        goto L53
    L13:
        r23 = false;
        goto L14
    L9:
        r20 = false;
        goto L10
    L5:
        r18 = false;
        goto L6
    }
}
