package com.obric.livecard.api.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/livecard/api/impl/ClientEvent;", "", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ClientEvent {
    public static final String CUSTOM_EVENT = "customEvent";
    public static final Companion Companion = null;
    public static final String HAS_CARD_CLICK = "hasCardClick";
    public static final String ON_CARD_CLICK = "onCardClick";
    public static final String ON_FLAGS_CHANGE = "onFlagsChange";
    public static final String ON_SESSION_ACTIVE = "onSessionActive";
    public static final String ON_SESSION_CREATE = "onSessionCreate";
    public static final String ON_SESSION_DESTROY = "onSessionDestroy";
    public static final String ON_SESSION_DISPLAY_STATUS_CHANGED = "onSessionDisplayStatusChanged";
    public static final String ON_SESSION_INACTIVE = "onSessionInactive";
    public static final String ON_SESSION_STATUS_CHANGED = "onSessionStatusChanged";
    public static final String ON_VIEW_CLICK = "onViewClick";
    public static final String ON_WIDGET_SHOW = "onWidgetShow";
    public static final String UPDATE_SESSION_CONFIG = "updateSessionConfig";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/livecard/api/impl/ClientEvent$Companion;", "", "()V", "CUSTOM_EVENT", "", "HAS_CARD_CLICK", "ON_CARD_CLICK", "ON_FLAGS_CHANGE", "ON_SESSION_ACTIVE", "ON_SESSION_CREATE", "ON_SESSION_DESTROY", "ON_SESSION_DISPLAY_STATUS_CHANGED", "ON_SESSION_INACTIVE", "ON_SESSION_STATUS_CHANGED", "ON_VIEW_CLICK", "ON_WIDGET_SHOW", "UPDATE_SESSION_CONFIG", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String CUSTOM_EVENT = "customEvent";
        public static final String HAS_CARD_CLICK = "hasCardClick";
        public static final String ON_CARD_CLICK = "onCardClick";
        public static final String ON_FLAGS_CHANGE = "onFlagsChange";
        public static final String ON_SESSION_ACTIVE = "onSessionActive";
        public static final String ON_SESSION_CREATE = "onSessionCreate";
        public static final String ON_SESSION_DESTROY = "onSessionDestroy";
        public static final String ON_SESSION_DISPLAY_STATUS_CHANGED = "onSessionDisplayStatusChanged";
        public static final String ON_SESSION_INACTIVE = "onSessionInactive";
        public static final String ON_SESSION_STATUS_CHANGED = "onSessionStatusChanged";
        public static final String ON_VIEW_CLICK = "onViewClick";
        public static final String ON_WIDGET_SHOW = "onWidgetShow";
        public static final String UPDATE_SESSION_CONFIG = "updateSessionConfig";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
