package com.obric.capabilitykit.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u000b\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode;", "", "()V", "AudioControl", "AutoGui", "Clock", "Companion", "Contacts", "EventTask", "Memory", "Message", "Music", "Office", "System", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ErrorCode {
    public static final int ACTION_EXECUTE_ERROR = -2003;
    public static final int ACTION_TIMEOUT_ERROR = 4;
    public static final int APPLETS_ERROR = 101;
    public static final int APP_NOT_EXIST_ERROR = 100;
    public static final int APP_VERSION_TOO_LOW = 106;
    public static final int AUTHENTICATION_ERROR = 111;
    public static final Companion Companion = null;
    public static final int DEVICE_LOCK_ERROR = 112;
    public static final int DISPATCH_ERROR = -2000;
    public static final int ENTITY_NOT_EXIST_ERROR = 200;
    public static final int EXECUTE_ACTION_ERROR = 102;
    public static final int GENERAL_ERROR = 1;
    public static final int INTENT_EXECUTE_ERROR = -2002;
    public static final int INTENT_NO_IMPL_ERROR = -2005;
    public static final int JOB_PARSE_ERROR = -2001;
    public static final int NETWORK_ERROR = 2;
    public static final int NOT_SUPPORTED = 999;
    public static final int NO_ERROR = 0;
    public static final int NO_LOGIN = 202;
    public static final int PARAMETER_ERROR = 103;
    public static final int PARAMS_MISS_ERROR = -2004;
    public static final int PERMISSION_ERROR = 113;
    public static final int PRIVACY_STATEMENT_NOT_AGREE_ERROR = 201;
    public static final int REGISTER_ERROR = 104;
    public static final int RESULT_TIMEOUT_ERROR = 5;
    public static final int UNREGISTER_ERROR = 105;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$AudioControl;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AudioControl {
        public static final Companion Companion = null;
        public static final int EXISTED_PLAYING_SESSION_ERROR = 3002;
        public static final int NO_CONTROLLABLE_SESSION_ERROR = 3001;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$AudioControl$Companion;", "", "()V", "EXISTED_PLAYING_SESSION_ERROR", "", "NO_CONTROLLABLE_SESSION_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public AudioControl() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$AutoGui;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AutoGui {
        public static final int AUTO_GUI_QUEUE_HAS_RUNNING_TASK_ERROR = 5001;
        public static final int AUTO_GUI_SYSTEM_ACCOUNT_NOT_LOGIN = 5002;
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$AutoGui$Companion;", "", "()V", "AUTO_GUI_QUEUE_HAS_RUNNING_TASK_ERROR", "", "AUTO_GUI_SYSTEM_ACCOUNT_NOT_LOGIN", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public AutoGui() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Clock;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Clock {
        public static final Companion Companion = null;
        public static final int TIMER_NOT_EXIST_ERROR = 2001;
        public static final int UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR = 2003;
        public static final int UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR = 2002;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Clock$Companion;", "", "()V", "TIMER_NOT_EXIST_ERROR", "", "UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR", "UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Clock() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Companion;", "", "()V", "ACTION_EXECUTE_ERROR", "", "ACTION_TIMEOUT_ERROR", "APPLETS_ERROR", "APP_NOT_EXIST_ERROR", "APP_VERSION_TOO_LOW", "AUTHENTICATION_ERROR", "DEVICE_LOCK_ERROR", "DISPATCH_ERROR", "ENTITY_NOT_EXIST_ERROR", "EXECUTE_ACTION_ERROR", "GENERAL_ERROR", "INTENT_EXECUTE_ERROR", "INTENT_NO_IMPL_ERROR", "JOB_PARSE_ERROR", "NETWORK_ERROR", "NOT_SUPPORTED", "NO_ERROR", "NO_LOGIN", "PARAMETER_ERROR", "PARAMS_MISS_ERROR", "PERMISSION_ERROR", "PRIVACY_STATEMENT_NOT_AGREE_ERROR", "REGISTER_ERROR", "RESULT_TIMEOUT_ERROR", "UNREGISTER_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Contacts;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Contacts {
        public static final int CONTACT_NO_PHONE_NUMBER_ERROR = 1001;
        public static final Companion Companion = null;
        public static final int PHONE_NO_PAGE_ERROR = 1100;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Contacts$Companion;", "", "()V", "CONTACT_NO_PHONE_NUMBER_ERROR", "", "PHONE_NO_PAGE_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Contacts() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$EventTask;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EventTask {
        public static final int ADD_TASK_ERROR = 8035;
        public static final int BATTERY_CHARGED_TO_PARAMS_EMPTY = 8026;
        public static final int BATTERY_DISCHARGED_TO_PARAMS_EMPTY = 8027;
        public static final int BLUETOOTH_CANDIDATE_INFO_EMPTY = 8038;
        public static final int BLUETOOTH_INFO_EMPTY = 8052;
        public static final int BLUETOOTH_NO_PERMISSION = 8054;
        public static final int BLUETOOTH_PARAMS_EMPTY = 8017;
        public static final int BLUETOOTH_SELECTED_ID_CONDITION_EMPTY = 8034;
        public static final int BLUETOOTH_SELECTED_ID_EMPTY = 8033;
        public static final int BLUETOOTH_SELECTED_NAME_EMPTY = 8018;
        public static final int BLUETOOTH_SWITCH_NOT_ENABLED = 8055;
        public static final int CONDITION_EMPTY = 8005;
        public static final Companion Companion = null;
        public static final int DEVICE_CONDITION_SIZE_ERROR = 8012;
        public static final int DEVICE_CONDITION_TYPE_ERROR = 8025;
        public static final int INSTRUCTION_EMPTY = 8003;
        public static final int INSTRUCTION_ILLEGAL = 8004;
        public static final int JSON_MERGE_ERROR = 8022;
        public static final int JSON_PARSE_ERROR = 8002;
        public static final int LOCATION_CUSTOM_INFO_EMPTY = 8011;
        public static final int LOCATION_CUSTOM_NAME_EMPTY = 8049;
        public static final int LOCATION_DATA_EMPTY = 8048;
        public static final int LOCATION_EVENT_TYPE_EMPTY = 8006;
        public static final int LOCATION_FLOW_ERROR = 8050;
        public static final int LOCATION_LOCATION_TYPE_EMPTY = 8007;
        public static final int LOCATION_NOT_PERMISSION = 8008;
        public static final int LOCATION_PLACE_ALIAS_INFO_EMPTY = 8009;
        public static final int LOCATION_SELECTED_ID_CONDITION_EMPTY = 8024;
        public static final int LOCATION_SELECTED_ID_EMPTY = 8023;
        public static final int LOCATION_SELECTED_NAME_EMPTY = 8010;
        public static final int PARAMS_EMPTY = 8001;
        public static final int PARSE_ENTITY_TO_JSON_ERROR = 8019;
        public static final int REPEATTYPE_ERROR = 8047;
        public static final int REPEATTYPE_MONTHLY_PARAMS_ERROR = 8045;
        public static final int REPEATTYPE_WEEKLY_PARAMS_ERROR = 8044;
        public static final int REPEATTYPE_YEARLY_PARAMS_ERROR = 8046;
        public static final int SMS_PARAMS_EMPTY = 8013;
        public static final int SMS_SELECTED_ID_CONDITION_EMPTY = 8030;
        public static final int SMS_SELECTED_ID_EMPTY = 8029;
        public static final int SMS_SELECTED_NAME_EMPTY = 8014;
        public static final int START_TIME_OR_END_TIME_ERROR = 8056;
        public static final int STORAGE_LOW_TO_PARAMS_EMPTY = 8028;
        public static final int TARGET_DATA_NOT_FOUND = 8021;
        public static final int TARGET_EMPTY = 8020;
        public static final int TIME_CONDITION_INTERVAL_ERROR = 8041;
        public static final int TIME_CONDITION_PARAMS_ERROR = 8040;
        public static final int TIME_CONDITION_TIME_FRAME_ERROR = 8043;
        public static final int TIME_CONDITION_TIME_POINT_ERROR = 8042;
        public static final int UPDATE_STATUS_ERROR = 8036;
        public static final int WIFI_CANDIDATE_INFO_EMPTY = 8037;
        public static final int WIFI_INFO_EMPTY = 8051;
        public static final int WIFI_NO_PERMISSION = 8053;
        public static final int WIFI_PARAMS_EMPTY = 8015;
        public static final int WIFI_SELECTED_ID_CONDITION_EMPTY = 8032;
        public static final int WIFI_SELECTED_ID_EMPTY = 8031;
        public static final int WIFI_SELECTED_NAME_EMPTY = 8016;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b7\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$EventTask$Companion;", "", "()V", "ADD_TASK_ERROR", "", "BATTERY_CHARGED_TO_PARAMS_EMPTY", "BATTERY_DISCHARGED_TO_PARAMS_EMPTY", "BLUETOOTH_CANDIDATE_INFO_EMPTY", "BLUETOOTH_INFO_EMPTY", "BLUETOOTH_NO_PERMISSION", "BLUETOOTH_PARAMS_EMPTY", "BLUETOOTH_SELECTED_ID_CONDITION_EMPTY", "BLUETOOTH_SELECTED_ID_EMPTY", "BLUETOOTH_SELECTED_NAME_EMPTY", "BLUETOOTH_SWITCH_NOT_ENABLED", "CONDITION_EMPTY", "DEVICE_CONDITION_SIZE_ERROR", "DEVICE_CONDITION_TYPE_ERROR", "INSTRUCTION_EMPTY", "INSTRUCTION_ILLEGAL", "JSON_MERGE_ERROR", "JSON_PARSE_ERROR", "LOCATION_CUSTOM_INFO_EMPTY", "LOCATION_CUSTOM_NAME_EMPTY", "LOCATION_DATA_EMPTY", "LOCATION_EVENT_TYPE_EMPTY", "LOCATION_FLOW_ERROR", "LOCATION_LOCATION_TYPE_EMPTY", "LOCATION_NOT_PERMISSION", "LOCATION_PLACE_ALIAS_INFO_EMPTY", "LOCATION_SELECTED_ID_CONDITION_EMPTY", "LOCATION_SELECTED_ID_EMPTY", "LOCATION_SELECTED_NAME_EMPTY", "PARAMS_EMPTY", "PARSE_ENTITY_TO_JSON_ERROR", "REPEATTYPE_ERROR", "REPEATTYPE_MONTHLY_PARAMS_ERROR", "REPEATTYPE_WEEKLY_PARAMS_ERROR", "REPEATTYPE_YEARLY_PARAMS_ERROR", "SMS_PARAMS_EMPTY", "SMS_SELECTED_ID_CONDITION_EMPTY", "SMS_SELECTED_ID_EMPTY", "SMS_SELECTED_NAME_EMPTY", "START_TIME_OR_END_TIME_ERROR", "STORAGE_LOW_TO_PARAMS_EMPTY", "TARGET_DATA_NOT_FOUND", "TARGET_EMPTY", "TIME_CONDITION_INTERVAL_ERROR", "TIME_CONDITION_PARAMS_ERROR", "TIME_CONDITION_TIME_FRAME_ERROR", "TIME_CONDITION_TIME_POINT_ERROR", "UPDATE_STATUS_ERROR", "WIFI_CANDIDATE_INFO_EMPTY", "WIFI_INFO_EMPTY", "WIFI_NO_PERMISSION", "WIFI_PARAMS_EMPTY", "WIFI_SELECTED_ID_CONDITION_EMPTY", "WIFI_SELECTED_ID_EMPTY", "WIFI_SELECTED_NAME_EMPTY", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public EventTask() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Memory;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Memory {
        public static final Companion Companion = null;
        public static final int ERROR_CLASSIFY = 6300;
        public static final int ERROR_UPDATE_BUT_RECALL_EMPTY = 6401;
        public static final int ERROR_UPDATE_BUT_RESULT_CREATE = 6402;
        public static final int ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT = 6400;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Memory$Companion;", "", "()V", "ERROR_CLASSIFY", "", "ERROR_UPDATE_BUT_RECALL_EMPTY", "ERROR_UPDATE_BUT_RESULT_CREATE", "ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Memory() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Message;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Message {
        public static final Companion Companion = null;
        public static final int MESSAGE_SEND_AIRPLANE_MODE = 9002;
        public static final int MESSAGE_SEND_NO_SIM = 9001;
        public static final int MESSAGE_TARGET_NOT_FOUND = 9003;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Message$Companion;", "", "()V", "MESSAGE_SEND_AIRPLANE_MODE", "", "MESSAGE_SEND_NO_SIM", "MESSAGE_TARGET_NOT_FOUND", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Message() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Music;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Music {
        public static final Companion Companion = null;
        public static final int NO_PLAYABLE_SEARCH_RESULT = 10003;
        public static final int NO_SEARCH_RESULT = 10001;
        public static final int PLAYLIST_EMPTY = 10002;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Music$Companion;", "", "()V", "NO_PLAYABLE_SEARCH_RESULT", "", "NO_SEARCH_RESULT", "PLAYLIST_EMPTY", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Music() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Office;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Office {
        public static final int CONTACT_NOT_EXIST_ERROR = 7002;
        public static final Companion Companion = null;
        public static final int EMPTY_COTENT_ERROR = 7003;
        public static final int GROUP_NOT_EXIST_ERROR = 7011;
        public static final int INVALID_ACCOUNT_ERROR = 7001;
        public static final int INVALID_COTENT_ERROR = 7010;
        public static final int KNOWLEDGE_GEN_FAIL = 7006;
        public static final int KNOWLEDGE_INSUFFICIENT_ERROR = 7012;
        public static final int KNOWLEDGE_NOT_AUTHORIZE = 7005;
        public static final int KNOWLEDGE_NOT_AVAILABLE = 7004;
        public static final int SEND_CANCEL_ERROR = 7013;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$Office$Companion;", "", "()V", "CONTACT_NOT_EXIST_ERROR", "", "EMPTY_COTENT_ERROR", "GROUP_NOT_EXIST_ERROR", "INVALID_ACCOUNT_ERROR", "INVALID_COTENT_ERROR", "KNOWLEDGE_GEN_FAIL", "KNOWLEDGE_INSUFFICIENT_ERROR", "KNOWLEDGE_NOT_AUTHORIZE", "KNOWLEDGE_NOT_AVAILABLE", "SEND_CANCEL_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Office() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$System;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class System {
        public static final Companion Companion = null;
        public static final int DOUBLE_CONFIRMATION_BEFORE_DOWNLOADING_ERROR = 4011;
        public static final int NO_SCREEN_RECORDING_ERROR = 4002;
        public static final int UNSUPPORTED_SCREEN_RECORDER_WHEN_KEYGUARD_LOCKED_ERROR = 4001;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/common/ErrorCode$System$Companion;", "", "()V", "DOUBLE_CONFIRMATION_BEFORE_DOWNLOADING_ERROR", "", "NO_SCREEN_RECORDING_ERROR", "UNSUPPORTED_SCREEN_RECORDER_WHEN_KEYGUARD_LOCKED_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public System() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ErrorCode() {
    }
}
