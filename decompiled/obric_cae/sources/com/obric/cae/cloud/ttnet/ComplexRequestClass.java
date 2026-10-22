package com.obric.cae.cloud.ttnet;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ComplexRequestClass {
    private String business_type;
    private List<ErrorInfo> error_list;
    private int optimize_item;
    private RemoteDeviceInfo remote_device_info;

    public static class ErrorInfo {
        private int category;
        private String error_code;
        private int error_count;
        private String error_message;
        private int issue_id;
        private String last_happened_time;
        private int module;
        private int profile_type;
        private String solution;
        private String unique_id;

        public ErrorInfo() {
        }
    }

    public static class Header {
        private String app_version;
        private int device_id;
        private String os_version;

        public Header() {
        }
    }

    public static class RemoteDeviceInfo {
        private int profile_count;
        private int remote_cod;
        private String remote_device_name;
        private String remote_mac;

        public RemoteDeviceInfo() {
        }
    }

    public ComplexRequestClass() {
    }
}
