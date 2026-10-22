package com.ss.ttvideoengine.strategrycenter;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MediaInfo {
    private int mComments;
    private double mDuration;
    private String mFormat;
    private int mLikes;
    private String mMediaID;
    private List<Representation> mRepresentations;
    private int mUserComment;
    private int mUserLike;
    private int mUserShare;

    public MediaInfo() {
    }

    public int getComments() {
        return this.mComments;
    }

    public double getDuration() {
        return this.mDuration;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public int getLikes() {
        return this.mLikes;
    }

    public String getMediaID() {
        return this.mMediaID;
    }

    public int getUserComment() {
        return this.mUserComment;
    }

    public int getUserLike() {
        return this.mUserLike;
    }

    public int getUserShare() {
        return this.mUserShare;
    }

    public void setComments(int r1) {
        this.mComments = r1;
    }

    public void setDuration(double r1) {
        this.mDuration = r1;
    }

    public void setFormat(String r1) {
        this.mFormat = r1;
    }

    public void setLikes(int r1) {
        this.mLikes = r1;
    }

    public void setMediaID(String r1) {
        this.mMediaID = r1;
    }

    public void setUserComment(int r1) {
        this.mUserComment = r1;
    }

    public void setUserLike(int r1) {
        this.mUserLike = r1;
    }

    public void setUserShare(int r1) {
        this.mUserShare = r1;
    }
}
