package com.ss.android.lark.location.service;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.listener.LocationRequestOption;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface g {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void a(LarkLocation r1);
    }

    boolean getLocation(Context r1, Token r2, Scene r3, a r4);

    d getLocationMessageMap();

    ILocationServiceType getLocationServiceType();

    boolean getLocationWithOption(Context r1, LocationRequestOption r2, Token r3, Scene r4, a r5);

    h getPOIService();

    IPickLocationMap getPickLocationMap();

    boolean isAdminGpsEnabled();

    boolean isAdminLocationMapSDKEnabled();

    boolean isGmsEnabled();

    boolean isInHouse(double r1, double r3);

    static {
        new ConcurrentHashMap();
    }
}
