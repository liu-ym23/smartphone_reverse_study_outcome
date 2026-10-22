package com.bytedance.android.livesdk.interactivity.api.publicscreen;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface n {
    void addMessageFactory(String r1, i.a r2);

    void addMessageInterceptor(PublicScreenConfig$InterceptorType r1, h r2);

    void addMessageListener(s42.b r1);

    void addMessageViewBinder(PublicScreenConfig$ViewBinderType r1, j<? extends i, ? extends PSMessageViewHolder> r2);

    l getPublicScreenContext();

    void removeMessageListener(s42.b r1);
}
