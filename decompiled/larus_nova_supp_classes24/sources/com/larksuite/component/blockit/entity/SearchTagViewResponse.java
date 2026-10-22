package com.larksuite.component.blockit.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class SearchTagViewResponse implements Serializable {
    public List<TagViewStruct> tagViews;

    public static class TagViewStruct implements Serializable {
        public String description;
        public String id;
        public boolean isAvailable;
        public boolean isSubscribed;
        public String name;
        public int permissionType;
        public String teamworkerCount;

        public TagViewStruct() {
        }
    }

    public SearchTagViewResponse() {
    }
}
